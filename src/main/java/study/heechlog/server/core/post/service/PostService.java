package study.heechlog.server.core.post.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.heechlog.server.core.post.domain.Post;
import study.heechlog.server.core.post.repository.PostRepository;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;

    /**
     * post 단건 조회
     */
    public Post findPost(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    /**
     * post 저장
     */
    @Transactional
    public Long savePost(Post post) {
        return postRepository.save(post).getId();
    }
}
