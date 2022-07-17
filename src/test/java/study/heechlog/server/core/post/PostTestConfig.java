package study.heechlog.server.core.post;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import study.heechlog.server.core.post.repository.PostQueryRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@TestConfiguration
public class PostTestConfig {

    @PersistenceContext
    EntityManager em;

    @Bean
    public PostQueryRepository postQueryRepository() {
        return new PostQueryRepository(em);
    }
}
