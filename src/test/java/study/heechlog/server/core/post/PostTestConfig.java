package study.heechlog.server.core.post;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import study.heechlog.server.core.post.repository.PostQueryRepository;
import study.heechlog.server.core.post.repository.PostRepository;
import study.heechlog.server.core.post.service.PostService;
import study.heechlog.server.core.user.repository.UserRepository;

@TestConfiguration
public class PostTestConfig {

    @PersistenceContext private EntityManager em;

    @Autowired PostRepository postRepository;

    @Autowired UserRepository userRepository;

    @Bean
    public PostQueryRepository postQueryRepository() {
        return new PostQueryRepository(em);
    }

    @Bean
    public PostService postService() {
        return new PostService(postRepository, postQueryRepository(), userRepository);
    }
}
