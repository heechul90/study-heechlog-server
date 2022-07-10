package study.heechlog.server.api.post.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import study.heechlog.server.api.post.controller.request.CreatePostRequest;
import study.heechlog.server.api.post.controller.response.CreatePostResponse;
import study.heechlog.server.core.common.json.JsonResult;
import study.heechlog.server.core.post.domain.Post;
import study.heechlog.server.core.post.dto.PostDto;
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
    public JsonResult findPost(@PathVariable("postId") Long postId) {
        Post findPost = postService.findPost(postId);
        PostDto post = PostDto.builder()
                .postId(findPost.getId())
                .postTitle(findPost.getTitle())
                .postContent(findPost.getContent())
                .build();
        return JsonResult.OK(post);
    }

    /**
     * post 저장
     */
    @PostMapping
    public JsonResult savePost(@RequestBody @Validated CreatePostRequest request) {
        Long savedId = postService.savePost(request.toEntity());
        return JsonResult.OK(new CreatePostResponse(savedId));
    }
}
