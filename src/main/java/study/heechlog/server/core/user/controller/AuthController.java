package study.heechlog.server.core.user.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.heechlog.server.config.AppConfig;
import study.heechlog.server.core.user.controller.reponse.SessionResponse;
import study.heechlog.server.core.user.controller.request.SigninRequest;
import study.heechlog.server.core.user.controller.request.SignupRequest;
import study.heechlog.server.core.user.service.AuthService;

import javax.crypto.SecretKey;
import java.util.Date;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final AppConfig appConfig;

    @PostMapping("/auth/login")
    public SessionResponse login(@RequestBody SigninRequest request) {
        Long userId = authService.signin(request);

        SecretKey key = Keys.hmacShaKeyFor(appConfig.getSecretKey());

        String jwt = Jwts.builder()
                .setSubject(String.valueOf(userId))
                .signWith(key)
                .setIssuedAt(new Date())
                .compact();

        return new SessionResponse(jwt);
    }

    @PostMapping("/auth/signup")
    public void signup(@RequestBody SignupRequest request) {
        authService.signup(request);
    }
}
