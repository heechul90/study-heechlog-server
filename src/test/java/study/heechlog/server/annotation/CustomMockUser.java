package study.heechlog.server.annotation;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithSecurityContextFactory;
import study.heechlog.server.config.UserPrincipal;
import study.heechlog.server.core.user.domain.User;
import study.heechlog.server.core.user.repository.UserRepository;

import java.util.List;

public class CustomMockUser implements WithSecurityContextFactory<CustomMockSecurityContext> {
    private final UserRepository userRepository;

    public CustomMockUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public SecurityContext createSecurityContext(CustomMockSecurityContext annotation) {
        String name = annotation.name();
        String email = annotation.email();
        String password = annotation.password();
//        String role = annotation.role();

        //로그인처리
        User user = User.builder()
                .name(name)
                .email(email)
                .password(password)
                .build();

        userRepository.save(user);
        var principal = new UserPrincipal(user);
        var role = new SimpleGrantedAuthority("ROLE_ADMIN");
        var token = new UsernamePasswordAuthenticationToken(principal, user.getPassword(), List.of(role));

        var context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(token);

        return context;
    }
}
