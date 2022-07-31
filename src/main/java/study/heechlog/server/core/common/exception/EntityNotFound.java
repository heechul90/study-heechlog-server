package study.heechlog.server.core.common.exception;

public class EntityNotFound extends RuntimeException {

    public static final String MESSAGE = "존재하지 않는 엔티티입니다.";

    public EntityNotFound() {
        super(MESSAGE);
    }

    public EntityNotFound(Throwable cause) {
        super(MESSAGE, cause);
    }
}
