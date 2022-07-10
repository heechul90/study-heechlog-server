package study.heechlog.server.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Error {

    private String fieldName;
    private String errorMessage;
}
