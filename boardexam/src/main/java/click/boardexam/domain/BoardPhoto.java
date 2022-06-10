package click.boardexam.domain;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.*;

@Entity
@Table(name = "board_Photo")
public class BoardPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_photo_id")
    private Long id;

    @Column(name = "board_photo_path", nullable = false)
    private String path;

    @ManyToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "board_id")
    private Board board;
}
