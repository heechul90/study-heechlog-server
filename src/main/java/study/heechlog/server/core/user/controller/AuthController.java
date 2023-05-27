package study.heechlog.server.core.user.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/auth/signin")
    @ResponseStatus(HttpStatus.OK)
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

    @GetMapping("/auth/login")
    public String login() {
        return "로그인 페이지입니다.";
    }

    @PostMapping("/auth/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(@RequestBody SignupRequest request) {
        authService.signup(request);
    }
}
