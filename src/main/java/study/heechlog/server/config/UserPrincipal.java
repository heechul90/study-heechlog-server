package study.heechlog.server.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public class UserPrincipal extends User {
    private final Long userId;

    public UserPrincipal(study.heechlog.server.core.user.domain.User user) {
        super(
                user.getEmail(),
                user.getPassword(),
                List.of(
                        new SimpleGrantedAuthority("ROLE_ADMIN"),
                        new SimpleGrantedAuthority("WRITE")
                )
        );
        this.userId = user.getId();
    }

    public Long getUserId() {
        return userId;
    }
}
