package study.heechlog.server.core.post.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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
import study.heechlog.server.core.post.dto.PostSearchCondition;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@Import(PostTestConfig.class)
class PostQueryRepositoryTest {

    @PersistenceContext EntityManager em;

    @Autowired PostQueryRepository postQueryRepository;

    @Test
    @DisplayName("게시글 목록 조회")
    void findPostsTest() {
        //given
        for (int i = 0; i < 50; i++) {
            em.persist(Post.createPostBuilder()
                    .title("제목" + i)
                    .content("내용" + i)
                    .build());
        }

        //when
        PostSearchCondition condition = new PostSearchCondition();
        PageRequest pageRequest = PageRequest.of(0, 20);

        Page<Post> content = postQueryRepository.findPosts(condition, pageRequest);

        //then
        assertThat(content.getTotalElements()).isEqualTo(50);
        assertThat(content.getContent().size()).isEqualTo(20);
    }
}