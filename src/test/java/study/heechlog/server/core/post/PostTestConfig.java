package study.heechlog.server.core.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import study.heechlog.server.core.post.repository.PostQueryRepository;
import study.heechlog.server.core.post.repository.PostRepository;
import study.heechlog.server.core.post.service.PostService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@TestConfiguration
public class PostTestConfig {

    @PersistenceContext
    EntityManager em;

    @Autowired PostRepository postRepository;

    @Bean
    public PostQueryRepository postQueryRepository() {
        return new PostQueryRepository(em);
    }

    @Bean
    public PostService postService() {
        return new PostService(postRepository, postQueryRepository());
    }
}
