package study.heechlog.server.core.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import study.heechlog.server.core.user.controller.request.SigninRequest;
import study.heechlog.server.core.user.controller.request.SignupRequest;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Transactional
class AuthControllerTest {

    //HEECHMAN
    public static final String HEECHMAN_EMAIL = "heechman@naver.com";
    public static final String HEECHMAN_PASSWORD = "1234";
    public static final String HEECHMAN_NAME = "히치맨";

    @Autowired private MockMvc mockMvc;
    @Autowired private ObjectMapper objectMapper;

    @Test
    @DisplayName("회원가입")
    void test01() throws Exception {
        //given
        SignupRequest request = SignupRequest.builder()
                .email(HEECHMAN_EMAIL)
                .password(HEECHMAN_PASSWORD)
                .name(HEECHMAN_NAME)
                .build();

        //expected
        mockMvc.perform(post("/auth/signup")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    @DisplayName("로그인")
    void test02() throws Exception {
        //given
        SigninRequest request = SigninRequest.builder()
                .email(HEECHMAN_EMAIL)
                .password(HEECHMAN_PASSWORD)
                .build();

        //expected
        mockMvc.perform(post("/auth/signin")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(request)))
                .andDo(print());

    }
}