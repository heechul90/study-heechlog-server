package study.heechlog.server.api.post.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Error {

    private String fieldName;
    private String errorMessage;
}
