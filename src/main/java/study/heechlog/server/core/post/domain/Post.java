package study.heechlog.server.core.post.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.heechlog.server.core.comment.domain.Comment;
import study.heechlog.server.core.post.dto.UpdatePostParam;

import jakarta.persistence.*;
import study.heechlog.server.core.user.domain.User;

import java.util.ArrayList;
import java.util.List;

import static io.jsonwebtoken.lang.Strings.hasText;

@Entity
@SequenceGenerator(
        name = "post_seq_generator",
        sequenceName = "post_seq",
        initialValue = 1, allocationSize = 50
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_seq_generator")
    @Column(name = "post_id")
    private Long id;

    private String title;

    @Lob
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    //===생성 메서드===//
    @Builder(builderClassName = "createPostBuilder", builderMethodName = "createPostBuilder")
    public Post(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }

    @Builder(builderClassName = "updatePostBuiler", builderMethodName = "updatePostBuiler")
    public void updatePost(UpdatePostParam param) {
        if (hasText(param.getTitle())) this.title = param.getTitle();
        if (hasText(param.getContent())) this.content = param.getContent();
    }
}
