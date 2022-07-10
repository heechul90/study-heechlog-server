package study.heechlog.server.core.post.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.heechlog.server.core.post.domain.Post;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class PostServiceTest {

    @Autowired PostService postService;

    @Test
    void findPostTest() {
        //given
        Post post = Post.createPostBuilder()
                .title("test_title")
                .content("test_content")
                .build();
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
        Post post = Post.createPostBuilder()
                .title("test_title")
                .content("test_content")
                .build();

        //when
        Long savedPost = postService.savePost(post);

        //then
        Post findPost = postService.findPost(savedPost);
        assertThat(findPost.getTitle()).isEqualTo("test_title");
        assertThat(findPost.getContent()).isEqualTo("test_content");
    }
}