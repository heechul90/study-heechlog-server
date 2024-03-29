package study.heechlog.server.core.post.controller.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import study.heechlog.server.core.post.dto.UpdatePostParam;

import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class UpdatePostRequest {

    @NotBlank(message = "제목을 입력하세요.")
    private String postTitle;
    private String postContent;

    public UpdatePostParam toParam() {
        return UpdatePostParam.builder()
                .title(this.postTitle)
                .content(this.postContent)
                .build();
    }
}
