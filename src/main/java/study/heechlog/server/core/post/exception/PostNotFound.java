package study.heechlog.server.core.post.exception;

import org.springframework.http.HttpStatus;
import study.heechlog.server.core.common.exception.CommonException;

public class PostNotFound extends CommonException {

    public static final String MESSAGE = "존재하지 않는 게시글입니다.";

    public PostNotFound() {
        super(MESSAGE);
    }

    @Override
    public HttpStatus status() {
        return HttpStatus.NOT_FOUND;
    }
}
