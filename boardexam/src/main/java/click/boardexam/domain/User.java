package click.boardexam.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
@Table(name = "users")
@Getter @Setter
public class User {

    @Id
    @Column(name = "user_uid")
    private String uid;

    @Column(name = "user_nickname", nullable = false)
    private String nickname;

    @Column(name = "user_password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", fetch = LAZY)
    private List<Board> boardList = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = LAZY)
    private List<Comment> commentList = new ArrayList<>();

    public User newUser(String uid) {
        this.uid = uid;
        return this;
    }
}
