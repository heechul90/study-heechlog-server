package study.heechlog.server.core.post.controller.request;

import lombok.*;
import study.heechlog.server.common.exception.InvalidRequest;
import study.heechlog.server.core.post.domain.Post;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class CreatePostRequest {

    @NotBlank(message = "제목을 입력하세요.")
    private String title;

    @NotBlank(message = "내용을 입력하세요.")
    private String content;

    public Post toEntity() {
        return Post.createPostBuilder()
                .title(this.getTitle())
                .content(this.getContent())
                .build();
    }

    public void validate() {
        if (this.title.contains("바보")) {
            throw new InvalidRequest("title", "제목에 바보를 포함할 수 없습니다.");
        } else if (this.content.contains("멍청이")) {
            throw new InvalidRequest("content", "내용에 멍청이를 포함할 수 없습니다.");
        }
    }
}
