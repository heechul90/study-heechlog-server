package study.heechlog.server.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import study.heechlog.server.common.json.Error;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class CommonException extends RuntimeException {

    List<Error> errors = new ArrayList<>();

    public CommonException(String message) {
        super(message);
    }

    public CommonException(String message, Throwable cause) {
        super(message, cause);
    }

    public abstract HttpStatus status();

    public void addValidation(String fieldName, String errorMessage) {
        errors.add(new Error(fieldName, errorMessage));
    }
}
