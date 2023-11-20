package study.heechlog.server.core.user.exception;

import org.springframework.http.HttpStatus;
import study.heechlog.server.common.exception.CommonException;

public class UserNotFound extends CommonException {

    public static final String MESSAGE = "존재하지 않는 사용자입니다.";

    public UserNotFound() {
        super(MESSAGE);
    }

    @Override
    public HttpStatus status() {
        return HttpStatus.NOT_FOUND;
    }
}
