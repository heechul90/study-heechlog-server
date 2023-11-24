package study.heechlog.server.annotation;

import org.springframework.security.test.context.support.WithSecurityContext;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@WithSecurityContext(factory = CustomMockUser.class)
public @interface CustomMockSecurityContext {
    String name() default "히치맨";
    String email() default "heechul@gmail.com";
    String password() default "";
    String role() default "ROLE_ADMIN";
}
