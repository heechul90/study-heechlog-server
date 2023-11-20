package study.heechlog.server.core.post.dto;

import lombok.Builder;
import study.heechlog.server.core.post.domain.Post;
import study.heechlog.server.core.user.domain.User;

@Builder
public record CreatePost(
        String title,
        String content
) {
    public Post toPost(User user) {
        return Post.createPostBuilder()
                .title(this.title)
                .content(this.content)
                .user(user)
                .build();
    }
}
