package study.heechlog.server.core.user.exception;

import org.springframework.http.HttpStatus;
import study.heechlog.server.common.exception.CommonException;

public class AlreadyExistsEmailException extends CommonException {

    private static final String MESSAGE = "이미 가입된 이메일입니다.";

    public AlreadyExistsEmailException() {
        super(MESSAGE);
    }

    @Override
    public HttpStatus status() {
        return HttpStatus.BAD_REQUEST;
    }
}
