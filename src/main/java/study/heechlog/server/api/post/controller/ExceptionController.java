package study.heechlog.server.api.post.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import study.heechlog.server.core.common.exception.CommonException;
import study.heechlog.server.core.common.json.Error;
import study.heechlog.server.core.common.json.JsonResult;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public JsonResult methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        List<Error> errors = new ArrayList<>();
        for (FieldError fieldError : e.getFieldErrors()) {
            errors.add(new Error(fieldError.getField(), fieldError.getDefaultMessage()));
        }
        return JsonResult.ERROR(HttpStatus.BAD_REQUEST, "잘못된 요청입니다.", errors);
    }

    @ExceptionHandler(CommonException.class)
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
