package study.heechlog.server.config.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import study.heechlog.server.common.json.JsonResult;

import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;

@Slf4j
@RequiredArgsConstructor
public class Http403Handler implements AccessDeniedHandler {
    private final ObjectMapper objectMapper;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        log.error("[인증오류] 접근할 수 없습니다.");

        JsonResult<Object> jsonResult = JsonResult.errorBuiler()
                .httpStatus(HttpStatus.FORBIDDEN)
                .message("접근할 수 없습니다.")
                .errors(null)
                .build();

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(UTF_8.name());
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        objectMapper.writeValue(response.getWriter(), jsonResult);
    }
}
