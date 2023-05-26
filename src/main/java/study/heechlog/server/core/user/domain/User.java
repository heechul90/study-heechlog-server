package study.heechlog.server.core.user.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@SequenceGenerator(
        name = "user_seq_generator",
        sequenceName = "user_seq",
        initialValue = 1, allocationSize = 50
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_generator")
    @Column(name = "user_id")
    private Long id;

    private String email;
    private String password;
    private String name;
    @CreatedDate
    private LocalDateTime createdDate;

    @Builder
    public User(String email, String password, String name) {
        this.email = email;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.name = name;
        this.createdDate = LocalDateTime.now();
    }
}
