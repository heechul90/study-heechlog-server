package study.heechlog.server.core.post.repository;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;
import study.heechlog.server.core.post.domain.Post;
import study.heechlog.server.core.post.dto.PostSearchCondition;

import javax.persistence.EntityManager;
import java.util.List;

import static study.heechlog.server.core.post.domain.QPost.post;

@Repository
public class PostQueryRepository {

    private final JPAQueryFactory queryFactory;

    public PostQueryRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    /**
     * post 목록 조회
     */
    public Page<Post> findPosts(PostSearchCondition condition, Pageable pageable) {
        List<Post> content = getPostList(pageable);

        JPAQuery<Long> count = getPostListCount();

        return PageableExecutionUtils.getPage(content, pageable, count::fetchOne);
    }

    /**
     * post 목록
     */
    private List<Post> getPostList(Pageable pageable) {
        List<Post> content = queryFactory
                .select(post)
                .from(post)
                .orderBy(post.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        return content;
    }

    /**
     * post 목록 카운트
     */
    private JPAQuery<Long> getPostListCount() {
        JPAQuery<Long> count = queryFactory
                .select(post.count())
                .from(post);
        return count;
    }
}
