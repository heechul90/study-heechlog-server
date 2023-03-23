package study.heechlog.server.core.user.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import study.heechlog.server.core.user.controller.request.SigninRequest;
import study.heechlog.server.core.user.exception.AlreadyExistsEmailException;
import study.heechlog.server.core.user.controller.request.SignupRequest;
import study.heechlog.server.core.user.domain.User;
import study.heechlog.server.core.user.exception.InvalidSigninInformation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@Transactional
class AuthServiceTest {

    //HEECHMAN
    public static final String HEECHMAN_EMAIL = "heechman@naver.com";
    public static final String HEECHMAN_PASSWORD = "1234";
    public static final String HEECHMAN_NAME = "히치맨";

    //HEECHMAN_WRONG
    public static final String HEECHMAN_WRONG_EMAIL = "heech@naver.com";
    public static final String HEECHMAN_WRONG_PASSWORD = "4321";

    @PersistenceContext private EntityManager em;
    @Autowired private AuthService authService;

    private static User getUser(String email, String password, String name) {
        return User.builder()
                .email(email)
                .password(password)
                .name(name)
                .build();
    }

    @Test
    @DisplayName("회원가입 성공")
    void test01() {
        //given
        SignupRequest request = SignupRequest.builder()
                .email(HEECHMAN_EMAIL)
                .password(HEECHMAN_PASSWORD)
                .name(HEECHMAN_NAME)
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
        User user = getUser(HEECHMAN_EMAIL, HEECHMAN_PASSWORD, HEECHMAN_NAME);
        em.persist(user);

        SignupRequest request = SignupRequest.builder()
                .email("heechman@naver.com")
                .password("1234")
                .name("히치맨")
                .build();

        //expected
        assertThatThrownBy(() -> authService.signup(request))
                .isInstanceOf(AlreadyExistsEmailException.class)
                .hasMessage("이미 가입된 이메일입니다.");
    }

    @Test
    @DisplayName("로그인 성공")
    void test03() {
        //given
        User user = getUser(HEECHMAN_EMAIL, HEECHMAN_PASSWORD, HEECHMAN_NAME);
        em.persist(user);

        SigninRequest request = SigninRequest.builder()
                .email(HEECHMAN_EMAIL)
                .password(HEECHMAN_PASSWORD)
                .build();

        //when
        Long signinUserId = authService.signin(request);

        //then
        assertThat(signinUserId).isNotNull();
    }

    @Test
    @DisplayName("로그인시 사용자 없음")
    void test04() {
        //given
        User user = getUser(HEECHMAN_EMAIL, HEECHMAN_PASSWORD, HEECHMAN_NAME);
        em.persist(user);

        SigninRequest request = SigninRequest.builder()
                .email(HEECHMAN_WRONG_EMAIL)
                .password(HEECHMAN_PASSWORD)
                .build();

        //when
        assertThatThrownBy(() -> authService.signin(request))
                .isInstanceOf(InvalidSigninInformation.class)
                .hasMessage("아이디 또는 비밀번호가 올바르지 않습니다.");
    }

    @Test
    @DisplayName("로그인시 비밀번호 틀림")
    void test05() {
        //given
        User user = getUser(HEECHMAN_EMAIL, HEECHMAN_PASSWORD, HEECHMAN_NAME);
        em.persist(user);

        SigninRequest request = SigninRequest.builder()
                .email(HEECHMAN_EMAIL)
                .password(HEECHMAN_WRONG_PASSWORD)
                .build();

        //when
        assertThatThrownBy(() -> authService.signin(request))
                .isInstanceOf(InvalidSigninInformation.class)
                .hasMessage("아이디 또는 비밀번호가 올바르지 않습니다.");
    }
}