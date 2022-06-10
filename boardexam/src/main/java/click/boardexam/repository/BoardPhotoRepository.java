package click.boardexam.repository;

import click.boardexam.domain.BoardPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardPhotoRepository extends JpaRepository<BoardPhoto, Long> {
}
