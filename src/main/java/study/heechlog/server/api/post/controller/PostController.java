package study.heechlog.server.api.post.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import study.heechlog.server.api.post.controller.request.CreatePostRequest;
import study.heechlog.server.core.post.domain.Post;
import study.heechlog.server.core.post.service.PostService;

@Slf4j
@RestController
@RequestMapping(value = "/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    /**
     * post 목록 조회
     */
    @GetMapping
    public void findPosts() {

    }

    /**
     * post 단건 조회
     */
    @GetMapping(value = "/{postId}")
    public Post findPost(@PathVariable("postId") Long postId) {
        Post post = postService.findPost(postId);
        return post;
    }

    /**
     * post 저장
     */
    @PostMapping
    public Long savePost(@RequestBody @Validated CreatePostRequest request) {
        Long savedId = postService.savePost(request.toEntity());
        return savedId;
    }
}
