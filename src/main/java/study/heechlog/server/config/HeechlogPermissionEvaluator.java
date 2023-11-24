package study.heechlog.server.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import study.heechlog.server.core.post.domain.Post;
import study.heechlog.server.core.post.exception.PostNotFound;
import study.heechlog.server.core.post.repository.PostRepository;

import java.io.Serializable;

@RequiredArgsConstructor
public class HeechlogPermissionEvaluator implements PermissionEvaluator {
    private final PostRepository postRepository;

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        var userPrincipal = (UserPrincipal) authentication.getPrincipal();

        Post findPost = postRepository.findById((Long) targetId)
                .orElseThrow(PostNotFound::new);

        if (!findPost.getUser().getId().equals(userPrincipal.getUserId())) {
            return false;
        }
        return true;
    }
}
