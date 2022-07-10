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
    void savePostTest() {
        //given
        Post post = new Post("test_title", "test_content");

        //when
        Long savedPost = postService.savePost(post);

        //then
        Post findPost = postService.findPost(savedPost);
        assertThat(findPost.getTitle()).isEqualTo("test_title");
        assertThat(findPost.getContent()).isEqualTo("test_content");
    }
}