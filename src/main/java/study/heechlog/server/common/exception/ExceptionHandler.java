package study.heechlog.server.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import study.heechlog.server.common.json.Error;
import study.heechlog.server.common.json.JsonResult;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public JsonResult methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        List<Error> errors = new ArrayList<>();
        for (FieldError fieldError : e.getFieldErrors()) {
            errors.add(new Error(fieldError.getField(), fieldError.getDefaultMessage()));
        }
        return JsonResult.ERROR(HttpStatus.BAD_REQUEST, "잘못된 요청입니다.", errors);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(CommonException.class)
    @ResponseBody
    public ResponseEntity<JsonResult> postException(CommonException e) {

        HttpStatus status = e.status();
        JsonResult<Object> body = JsonResult.errorBuiler()
                .httpStatus(status)
                .message(e.getMessage())
                .errors(e.getErrors())
                .build();

        ResponseEntity<JsonResult> response = ResponseEntity.status(e.status())
                .body(body);
        return response;
    }

}
