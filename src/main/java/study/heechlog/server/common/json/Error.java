package study.heechlog.server.common.json;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Error {

    private String fieldName;
    private String errorMessage;
}
