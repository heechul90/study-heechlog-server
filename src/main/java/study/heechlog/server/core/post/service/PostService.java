package study.heechlog.server.core.post.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.heechlog.server.core.post.domain.Post;
import study.heechlog.server.core.post.dto.CreatePost;
import study.heechlog.server.core.post.dto.UpdatePostParam;
import study.heechlog.server.core.post.dto.PostSearchCondition;
import study.heechlog.server.core.post.exception.PostNotFound;
import study.heechlog.server.core.post.repository.PostQueryRepository;
import study.heechlog.server.core.post.repository.PostRepository;
import study.heechlog.server.core.user.domain.User;
import study.heechlog.server.core.user.exception.UserNotFound;
import study.heechlog.server.core.user.repository.UserRepository;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository;
    private final PostQueryRepository postQueryRepository;
    private final UserRepository userRepository;

    /**
     * post 목록 조회
     */
    public Page<Post> findPosts(PostSearchCondition condition, Pageable pageable) {
        return postQueryRepository.findPosts(condition, pageable);
    }

    /**
     * post 단건 조회
     */
    public Post findPost(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(PostNotFound::new);
    }

    /**
     * post 저장
     */
    @Transactional
    public Long savePost(long userId, CreatePost createPost) {
        User findUser = userRepository.findById(userId)
                .orElseThrow(UserNotFound::new);
        return postRepository.save(createPost.toPost(findUser)).getId();
    }

    /**
     * post 수정
     */
    @Transactional
    public void updatePost(Long postId, UpdatePostParam param) {
        Post findPost = postRepository.findById(postId)
                .orElseThrow(PostNotFound::new);
        findPost.updatePostBuiler()
                .param(param)
                .build();
    }

    /**
     * post 삭제
     */
    @Transactional
    public void deletePost(Long postId) {
        Post findPost = postRepository.findById(postId)
                .orElseThrow(PostNotFound::new);
        postRepository.delete(findPost);
    }
}
