package study.heechlog.server.core.post.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    //===생성 메서드===//
    @Builder(builderClassName = "createPostBuilder", builderMethodName = "createPostBuilder")
    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
