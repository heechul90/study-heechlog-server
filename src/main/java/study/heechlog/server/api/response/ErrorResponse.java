package study.heechlog.server.api.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class ErrorResponse {

    private final HttpStatus status;
    private final String message;
    private List<Error> errors = new ArrayList<>();
}
