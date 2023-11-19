package study.heechlog.server.core.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.heechlog.server.core.user.exception.AlreadyExistsEmailException;
import study.heechlog.server.core.user.controller.request.SigninRequest;
import study.heechlog.server.core.user.controller.request.SignupRequest;
import study.heechlog.server.core.user.domain.User;
import study.heechlog.server.core.user.exception.InvalidSigninInformation;
import study.heechlog.server.core.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public Long signin(SigninRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(InvalidSigninInformation::new);

        if (!new BCryptPasswordEncoder().matches(request.getPassword(), user.getPassword())) {
            throw new InvalidSigninInformation();
        }

        return user.getId();
    }

    @Transactional
    public Long signup(SignupRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new AlreadyExistsEmailException();
        }

        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .build();

        return userRepository.save(user).getId();
    }
}
