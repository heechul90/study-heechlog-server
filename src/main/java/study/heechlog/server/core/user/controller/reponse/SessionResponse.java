package study.heechlog.server.core.user.controller.reponse;

import lombok.Getter;

@Getter
public class SessionResponse {

    private final String accessToken;

    public SessionResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
