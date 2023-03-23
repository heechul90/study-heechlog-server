package study.heechlog.server.core.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import study.heechlog.server.common.exception.AlreadyExistsEmailException;
import study.heechlog.server.common.exception.InvalidRequest;
import study.heechlog.server.core.user.controller.request.LoginRequest;
import study.heechlog.server.core.user.controller.request.SignupRequest;
import study.heechlog.server.core.user.domain.User;
import study.heechlog.server.core.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public Long signin(LoginRequest request) {
        User user = userRepository.findByEmailAndPassword(request.getEmail(), request.getPassword())
                .orElseThrow(() -> new IllegalArgumentException("없음"));

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean matches = passwordEncoder.matches(request.getPassword(), user.getPassword());
        if (!matches) {
            throw new IllegalArgumentException("비밀번호 틀림");
        }

        return user.getId();
    }

    public Long signup(SignupRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new AlreadyExistsEmailException();
        }

        User user = User.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .name(request.getName())
                .build();

        return userRepository.save(user).getId();
    }
}
