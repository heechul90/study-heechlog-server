package study.heechlog.server.core.post.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import study.heechlog.server.core.post.PostTestConfig;
import study.heechlog.server.core.post.domain.Post;
import study.heechlog.server.core.post.dto.CreatePost;
import study.heechlog.server.core.post.dto.PostSearchCondition;
import study.heechlog.server.core.post.dto.UpdatePostParam;
import study.heechlog.server.core.post.exception.PostNotFound;
import study.heechlog.server.core.post.repository.PostRepository;
import study.heechlog.server.core.user.domain.User;
import study.heechlog.server.core.user.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(PostTestConfig.class)
class PostServiceTest {

    @PersistenceContext private EntityManager em;

    @Autowired PostRepository postRepository;

    @Autowired UserRepository userRepository;

    @Autowired PostService postService;

    @BeforeEach
    void clean() {
        postRepository.deleteAll();
        userRepository.deleteAll();
    }

    private Post getPost(String title, String content) {
        Post post = Post.createPostBuilder()
                .title(title)
                .content(content)
                .build();
        return post;
    }

    @Test
    @DisplayName("게시글 목록 조회")
    void findPostsTest() {
        //given
        List<Post> requestPosts = IntStream.range(0, 30)
                .mapToObj(i -> Post.createPostBuilder()
                        .title("제목 - " + i)
                        .content("내용 - " + i)
                        .build()
                )
                .collect(Collectors.toList());
        postRepository.saveAll(requestPosts);

        PostSearchCondition condition = new PostSearchCondition();
        PageRequest pageRequest = PageRequest.of(0, 10);

        //when
        Page<Post> contents = postService.findPosts(condition, pageRequest);

        //then
        assertThat(contents.getTotalElements()).isEqualTo(30);
        assertThat(contents.getContent().size()).isEqualTo(10);
    }

    @Test
    @DisplayName("게시글 단건 조회")
    void findPostTest() {
        //given
        CreatePost createPost = getCreatePost("test_title", "test_content");
        User user = User.builder()
                .name("희치맨")
                .email("heechman@naver.com")
                .password("1234")
                .build();
        userRepository.save(user);
        Long savedId = postService.savePost(user.getId(), createPost);

        //when
        Post findPost = postService.findPost(savedId);


        //then
        assertThat(findPost.getTitle()).isEqualTo("test_title");
        assertThat(findPost.getContent()).isEqualTo("test_content");
        assertThatThrownBy(() -> postService.findPost(savedId + 1L))
                .isInstanceOf(PostNotFound.class)
                .hasMessageStartingWith("존재하지 않는")
                .hasMessageEndingWith("게시글입니다.");
    }

    @Test
    @DisplayName("게시글 저장")
    void savePostTest() {
        //given
        CreatePost createPost = getCreatePost("test_title", "test_content");

        User user = User.builder()
                .name("희치맨")
                .email("heechman@naver.com")
                .password("1234")
                .build();
        userRepository.save(user);

        //when
        Long savedPost = postService.savePost(user.getId(), createPost);

        //then
        Post findPost = postService.findPost(savedPost);
        assertThat(findPost.getTitle()).isEqualTo("test_title");
        assertThat(findPost.getContent()).isEqualTo("test_content");
    }

    @Test
    @DisplayName("게시글 수정")
    void updatePostTest() {
        //given
        Post post = getPost("test_title", "test_content");
        em.persist(post);

        UpdatePostParam param = UpdatePostParam.builder()
                .title("update_title")
                .content("update_content")
                .build();

        //when
        postService.updatePost(post.getId(), param);

        //then
        Post findPost = em.find(Post.class, post.getId());
        assertThat(findPost.getTitle()).isEqualTo("update_title");
        assertThat(findPost.getContent()).isEqualTo("update_content");
        assertThatThrownBy(() -> postService.updatePost(post.getId() + 1L, param))
                .isInstanceOf(PostNotFound.class)
                .hasMessageStartingWith("존재하지 않는")
                .hasMessageEndingWith("게시글입니다.");
    }

    @Test
    @DisplayName("게시글 삭제")
    void deletePostTest() {
        //given
        Post post = getPost("test_title", "test_content");
        em.persist(post);

        //when
        postService.deletePost(post.getId());

        //then
        assertThatThrownBy(() -> postService.findPost(post.getId()))
                .isInstanceOf(PostNotFound.class)
                .hasMessageStartingWith("존재하지 않는")
                .hasMessageEndingWith("게시글입니다.");
    }

    private static CreatePost getCreatePost(String title, String content) {
        return CreatePost.builder()
                .title(title)
                .content(content)
                .build();
    }
}