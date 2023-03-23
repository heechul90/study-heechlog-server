package study.heechlog.server.core.user.controller.request;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignupRequest {

    private String email;
    private String password;
    private String name;

    @Builder
    public SignupRequest(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
}
