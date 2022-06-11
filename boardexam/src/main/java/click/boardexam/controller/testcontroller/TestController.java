package click.boardexam.controller.testcontroller;

import click.boardexam.repository.UserRepository;
import click.boardexam.security.AuthUser;
import click.boardexam.service.BoardService;
import click.boardexam.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {

    private BoardService boardService;

    //게시물 등록 API
    @PostMapping(value = "/board", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public String saveBoard(@AuthenticationPrincipal AuthUser authUser,
                            @RequestPart BoardService.BoardReqDto boardReqDto,
                            @RequestPart(value = "file", name = "file", required = false)MultipartFile file) {
        boardService.saveBoard(boardReqDto, authUser);
        return "게시물 등록 완료";
    }
}
