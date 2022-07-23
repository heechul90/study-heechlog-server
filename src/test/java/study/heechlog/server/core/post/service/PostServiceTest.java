package study.heechlog.server.core.post.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import study.heechlog.server.core.post.PostTestConfig;
import study.heechlog.server.core.post.domain.Post;
import study.heechlog.server.core.post.dto.PostSearchCondition;
import study.heechlog.server.core.post.dto.UpdatePostParam;
import study.heechlog.server.core.post.repository.PostRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(PostTestConfig.class)
class PostServiceTest {

    @PersistenceContext EntityManager em;

    @Autowired PostRepository postRepository;

    @Autowired PostService postService;

    private Post getPost(String title, String content) {
        Post post = Post.createPostBuilder()
                .title(title)
                .content(content)
                .build();
        return post;
    }

    @Test
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
    void findPostTest() {
        //given
        Post post = getPost("test_title", "test_content");
        Long savedId = postService.savePost(post);

        //when
        Post findPost = postService.findPost(savedId);

        //then
        assertThat(findPost.getTitle()).isEqualTo("test_title");
        assertThat(findPost.getContent()).isEqualTo("test_content");
        assertThatThrownBy(() -> postService.findPost(9999999999999L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("존재하지 않는 글입니다.");
    }

    @Test
    void savePostTest() {
        //given
        Post post = getPost("test_title", "test_content");

        //when
        Long savedPost = postService.savePost(post);

        //then
        Post findPost = postService.findPost(savedPost);
        assertThat(findPost.getTitle()).isEqualTo("test_title");
        assertThat(findPost.getContent()).isEqualTo("test_content");
    }

    @Test
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
    }
}