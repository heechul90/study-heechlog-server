package study.heechlog.server.core.user.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import study.heechlog.server.common.exception.AlreadyExistsEmailException;
import study.heechlog.server.core.user.controller.request.SignupRequest;
import study.heechlog.server.core.user.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@Transactional
class AuthServiceTest {

    @PersistenceContext private EntityManager em;
    @Autowired private AuthService authService;

    @Test
    @DisplayName("회원가입 성공")
    void test01() {
        //given
        SignupRequest request = SignupRequest.builder()
                .email("heech@naver.com")
                .password("1234")
                .name("히치맨")
                .build();

        //when
        Long signupId = authService.signup(request);

        //then
        User findUser = em.find(User.class, signupId);
        assertThat(findUser.getEmail()).isEqualTo(request.getEmail());
        assertThat(new BCryptPasswordEncoder().matches(request.getPassword(), findUser.getPassword())).isTrue();
        assertThat(findUser.getName()).isEqualTo(request.getName());
    }

    @Test
    @DisplayName("회원가입시 중복 이메일")
    void test02() {
        //given
        User yoloman = User.builder()
                .email("heech@naver.com")
                .password("1234")
                .name("욜로맨")
                .build();
        em.persist(yoloman);

        SignupRequest request = SignupRequest.builder()
                .email("heech@naver.com")
                .password("1234")
                .name("히치맨")
                .build();

        //expected
        assertThatThrownBy(() -> authService.signup(request))
                .isInstanceOf(AlreadyExistsEmailException.class)
                .hasMessage("이미 가입된 이메일입니다.");
    }
}