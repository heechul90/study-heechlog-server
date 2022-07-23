package study.heechlog.server.core.post.dto;

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
