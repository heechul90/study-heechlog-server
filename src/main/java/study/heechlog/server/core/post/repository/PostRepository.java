package study.heechlog.server.core.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.heechlog.server.core.post.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
