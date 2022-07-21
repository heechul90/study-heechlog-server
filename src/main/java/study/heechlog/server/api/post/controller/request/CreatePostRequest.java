package study.heechlog.server.api.post.controller.request;

import lombok.*;
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
}
