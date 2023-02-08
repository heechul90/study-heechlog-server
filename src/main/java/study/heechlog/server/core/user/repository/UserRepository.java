package study.heechlog.server.core.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.heechlog.server.core.user.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
