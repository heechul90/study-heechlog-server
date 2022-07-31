package study.heechlog.server.core.common.json;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Builder
@SuppressWarnings("unchecked")
//@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class JsonResult<T> {

    private HttpStatus status;
    private String message;

    private List<Error> errors;
    private T data;

    public static <T> JsonResult<T> OK() {
        return (JsonResult<T>) JsonResult.builder()
                .status(HttpStatus.OK)
                .build();
    }

    public static <T> JsonResult<T> OK(T data) {
        return (JsonResult<T>) JsonResult.builder()
                .status(HttpStatus.OK)
                .data(data)
                .build();
    }

    @Builder(builderClassName = "errorBuiler", builderMethodName = "errorBuiler")
    public static <T> JsonResult<T> ERROR(HttpStatus httpStatus, String message, List<Error> errors) {
        return (JsonResult<T>) JsonResult.builder()
                .status(httpStatus)
                .message(message)
                .errors(errors)
                .build();
    }
}
