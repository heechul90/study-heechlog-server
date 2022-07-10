package study.heechlog.server.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import study.heechlog.server.api.request.PostCreateRequest;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/api/posts")
public class PostController {

    @PostMapping
    public Map<String, String> savePost(@RequestBody @Validated PostCreateRequest request) {
        return Map.of();
    }
}
