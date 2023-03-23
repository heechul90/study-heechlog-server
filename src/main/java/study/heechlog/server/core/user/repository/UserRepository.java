package study.heechlog.server.core.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.heechlog.server.core.user.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailAndPassword(String email, String password);

    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);
}
