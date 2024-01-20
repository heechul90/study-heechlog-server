package study.heechlog.server.core.comment.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.heechlog.server.core.post.domain.Post;

@Entity
@Table(indexes = {@Index(name = "IDX_COMMENT_POST_ID", columnList = "post_id")})
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @Column(nullable = false)
    private String content;

    private String author;

    private String password;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

}
