package study.heechlog.server.core.post.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UpdatePostParam {

    private String title;
    private String content;

    @Builder
    public UpdatePostParam(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
