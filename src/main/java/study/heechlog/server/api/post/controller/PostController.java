package study.heechlog.server.api.post.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import study.heechlog.server.api.post.controller.request.CreatePostRequest;
import study.heechlog.server.api.post.controller.request.UpdatePostRequest;
import study.heechlog.server.api.post.controller.response.CreatePostResponse;
import study.heechlog.server.api.post.controller.response.UpdatePostResponse;
import study.heechlog.server.core.common.json.JsonResult;
import study.heechlog.server.core.post.domain.Post;
import study.heechlog.server.core.post.dto.PostDto;
import study.heechlog.server.core.post.dto.PostSearchCondition;
import study.heechlog.server.core.post.service.PostService;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/posts")
public class PostController {

    private final PostService postService;

    /**
     * post 목록 조회
     */
    @GetMapping
    public JsonResult findPosts(PostSearchCondition condition, Pageable pageable) {
        Page<Post> contents = postService.findPosts(condition, pageable);
        List<PostDto> collect = contents.getContent().stream()
                .map(post -> PostDto.builder()
                        .postId(post.getId())
                        .postTitle(post.getTitle())
                        .postContent(post.getContent())
                        .build()
                )
                .collect(Collectors.toList());
        return JsonResult.OK(collect);
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

    /**
     * post 수정
     */
    @PutMapping(value = "/{postId}")
    public JsonResult updatePost(@PathVariable("postId") Long postId,
                                 @RequestBody @Validated UpdatePostRequest request) {

        postService.updatePost(postId, request.toParam());
        Post post = postService.findPost(postId);
        return JsonResult.OK(new UpdatePostResponse(post.getId()));
    }

    /**
     * post 삭제
     */
    @DeleteMapping(value = "/{postId}")
    public JsonResult deletePost(@PathVariable("postId") Long postId) {
        postService.deletePost(postId);
        return JsonResult.OK();
    }
}
