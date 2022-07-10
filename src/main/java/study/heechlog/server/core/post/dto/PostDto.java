package study.heechlog.server.core.post.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PostDto {

    private Long postId;
    private String postTitle;
    private String postContent;

    @Builder
    public PostDto(Long postId, String postTitle, String postContent) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.postContent = postContent;
    }
}
