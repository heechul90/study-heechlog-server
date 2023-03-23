package study.heechlog.server.core.user.controller.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SigninRequest {

    @NotBlank(message = "이메일을 입력해주세요.")
    private String email;
    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;

    @Builder
    public SigninRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
