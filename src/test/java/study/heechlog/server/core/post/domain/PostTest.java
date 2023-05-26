package study.heechlog.server.core.post.domain;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class PostTest {

    @PersistenceContext EntityManager em;

    @Test
    @DisplayName("게시글 엔티티 생성 확인")
    public void createEntityTest(){
        //given
        Post post = Post.createPostBuilder()
                .title("test_title")
                .content("test_content")
                .build();

        //when
        em.persist(post);

        //then
        Post findPost = em.find(Post.class, post.getId());
        assertThat(findPost.getTitle()).isEqualTo("test_title");
        assertThat(findPost.getContent()).isEqualTo("test_content");
    }
}