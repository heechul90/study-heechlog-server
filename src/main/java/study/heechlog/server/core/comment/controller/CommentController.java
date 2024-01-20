package study.heechlog.server.core.comment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import study.heechlog.server.core.comment.service.CommentService;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
}
