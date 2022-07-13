package study.heechlog.server.core.post.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.heechlog.server.core.post.domain.Post;
import study.heechlog.server.core.post.repository.PostRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@Transactional
class PostServiceTest {

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
    void findPostWithPageTest() throws Exception{
        //given
        List<Post> requestPosts = IntStream.range(0, 30)
                .mapToObj(i -> Post.createPostBuilder()
                        .title("제목 - " + i)
                        .content("내용 - " + i)
                        .build()
                )
                .collect(Collectors.toList());
        postRepository.saveAll(requestPosts);

        //when

        //then
    }

    @Test
    public void findPostsTest() throws Exception{
        //given
        Post post1 = getPost("test_title1", "test_content1");
        Post post2 = getPost("test_title2", "test_content2");
        postService.savePost(post1);
        postService.savePost(post2);

        //when
        List<Post> posts = postService.findPosts();

        //then
        assertThat(posts.size()).isEqualTo(2);
        assertThat(posts).extracting("title").containsExactly("test_title1", "test_title2");
        assertThat(posts).extracting("content").containsExactly("test_content1", "test_content2");
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
}