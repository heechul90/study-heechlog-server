package study.heechlog.server.core.common.web;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class CommonController {

    private final MessageSource messageSource;

    public CommonController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
}
