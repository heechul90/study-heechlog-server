package study.heechlog.server.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;
import study.heechlog.server.core.user.domain.User;
import study.heechlog.server.core.user.repository.UserRepository;

import java.io.IOException;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@Slf4j
@RequiredArgsConstructor
@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig {
    private final UserRepository userRepository;

    @Bean
    protected WebSecurityCustomizer webSecurityCustomizer() {
        return new WebSecurityCustomizer() {
            @Override
            public void customize(WebSecurity web) {
                web.ignoring()
                        .requestMatchers("/favicon.ico")
                        .requestMatchers("/error")
                        .requestMatchers(toH2Console());
            }
        };
    }

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests()
                    .requestMatchers("/auth/login").permitAll()
                    .requestMatchers("/auth/signup").permitAll()
//                    .requestMatchers("/user").hasAnyRole("USER", "ADMIN")
                    .requestMatchers("/admin")
                        .access(new WebExpressionAuthorizationManager("hasRole('ADMIN') AND hasAuthority('WRITE')"))
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/auth/login")
                    .loginProcessingUrl("/auth/login")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .defaultSuccessUrl("/")
                .and()
                    .exceptionHandling(e -> {
                        new AccessDeniedHandler() {
                            @Override
                            public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
                                log.info("403", accessDeniedException);
                            }
                        };
                    })
                    .rememberMe(rm -> rm.rememberMeParameter("remember")
                            .alwaysRemember(false)
                            .tokenValiditySeconds(2592000)
                    )
                    .csrf(AbstractHttpConfigurer::disable)
                .build();
    }

    @Bean
    protected UserDetailsService userDetailsService() {
        return username -> {
            User findUser = userRepository.findByEmail(username)
                    .orElseThrow(() -> new UsernameNotFoundException(username + "을 찾을 수 없습니다."));
            return new UserPrincipal(findUser);
        };
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        UserDetails user = User
//                .withUsername("heechul")
//                .password(new BCryptPasswordEncoder().encode("1234"))
//                .roles("ADMIN")
//                .build();
//        manager.createUser(user);
//        return manager;
    }
}
