package study.heechlog.server.core.post.exception;

import study.heechlog.server.core.common.exception.CommonException;

public class PostNotFound extends CommonException {

    public static final String MESSAGE = "존재하지 않는 게시물입니다.";

    public PostNotFound() {
        super(MESSAGE);
    }
}
