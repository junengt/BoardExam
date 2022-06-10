package click.boardexam.service;

import click.boardexam.domain.Board;
import click.boardexam.exception.UidNotFoundException;
import click.boardexam.repository.BoardRepository;
import click.boardexam.repository.UserRepository;
import click.boardexam.security.AuthUser;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public Long saveBoard(BoardReqDto boardReqDto, AuthUser authUser) {
        userRepository.findByUid(authUser.getUid()).orElseThrow(() -> new UidNotFoundException("UID를 찾을 수 없습니다"));
        Board board = Board.builder()
                .title(boardReqDto.getTitle()).
                content(boardReqDto.getContent()).
                build();
        boardRepository.save(board);
        return board.getId();
    }

    @Data
    private class BoardReqDto {
        private String title;
        private String content;
    }
}
