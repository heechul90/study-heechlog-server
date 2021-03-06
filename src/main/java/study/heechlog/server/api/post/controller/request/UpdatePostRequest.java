package study.heechlog.server.api.post.controller.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import study.heechlog.server.core.post.dto.UpdatePostParam;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class UpdatePostRequest {

    private String postTitle;
    private String postContent;

    public UpdatePostParam toParam() {
        return UpdatePostParam.builder()
                .title(this.postTitle)
                .content(this.postContent)
                .build();
    }
}
