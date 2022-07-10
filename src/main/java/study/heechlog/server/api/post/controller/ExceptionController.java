package study.heechlog.server.api.post.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import study.heechlog.server.api.post.controller.response.Error;
import study.heechlog.server.api.post.controller.response.ErrorResponse;

@Slf4j
@ControllerAdvice
public class ExceptionController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ErrorResponse methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {

        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, "잘못된 요청입니다.");

        for (FieldError fieldError : e.getFieldErrors()) {
            errorResponse.getErrors().add(new Error(fieldError.getField(), fieldError.getDefaultMessage()));
        }
        return errorResponse;
    }
}
