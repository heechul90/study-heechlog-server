package study.heechlog.server.api.post.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import study.heechlog.server.api.post.controller.request.PostCreateRequest;
import study.heechlog.server.core.post.domain.Post;
import study.heechlog.server.core.post.service.PostService;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/posts")
public class PostController {

    private final PostService postService;

    @PostMapping
    public Map<String, String> savePost(@RequestBody @Validated PostCreateRequest request) {
        Post post = new Post(request.getTitle(), request.getContent());
        Long savedId = postService.savePost(post);
        return Map.of();
    }
}
