package study.heechlog.server.annotation;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.test.context.support.WithSecurityContextFactory;
import study.heechlog.server.core.user.repository.UserRepository;

import java.lang.annotation.Annotation;

public class MockUserFactory implements WithSecurityContextFactory<CustomWithMockUser> {
    private UserRepository userRepository;

    @Override
    public SecurityContext createSecurityContext(CustomWithMockUser annotation) {
        String username = annotation.username();
        String password = annotation.password();
        int level = annotation.level();
        String mobileNumber = annotation.mobileNumber();

        //로그인처리

        return null;
    }
}
