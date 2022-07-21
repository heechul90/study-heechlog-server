package study.heechlog.server.api.post.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePostRequest {

    private String postTitle;
    private String postContent;
}
