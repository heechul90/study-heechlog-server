package study.heechlog.server.core.user.exception;

import org.springframework.http.HttpStatus;
import study.heechlog.server.common.exception.CommonException;

public class InvalidSigninInformation extends CommonException {

    private static final String MESSAGE = "아이디 또는 비밀번호가 올바르지 않습니다.";

    public InvalidSigninInformation() {
        super(MESSAGE);
    }

    @Override
    public HttpStatus status() {
        return HttpStatus.BAD_REQUEST;
    }
}
