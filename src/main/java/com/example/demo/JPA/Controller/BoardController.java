package com.example.demo.JPA.Controller;

import com.example.demo.JPA.Dto.BoardReplyDto;
import com.example.demo.JPA.Dto.ReplyDeleteDto;
import com.example.demo.JPA.Dto.boardReadFormDto;
import com.example.demo.JPA.Entity.BoardMany;
import com.example.demo.JPA.Entity.User;
import com.example.demo.JPA.Service.BoardReplyService;
import com.example.demo.JPA.Service.BoardService;
import com.example.demo.JPA.Service.loginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Enumeration;
import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    @Autowired
    private final BoardService boardService;

    @Autowired
    private final BoardReplyService boardReplyService;

    @Autowired
    private final loginService ls;


    @GetMapping("/read/{id}")
    public String read( @PathVariable Long id
//            , @RequestParam(defaultValue = "0") int page
//            ,@RequestParam(defaultValue = "10") int size
//                        ,@RequestBody int page
//                        ,@RequestBody int size
            , Model model){


        //getBoardWithReply 2개 (페이지용, 그냥 리스트)
        boardReadFormDto boardReadFormDto = boardReplyService.getBoardWithReply(id);

        if(boardReadFormDto != null){
            model.addAttribute("boardMany", boardReadFormDto.getBoardMany());
            model.addAttribute("Replies", boardReadFormDto.getBoardRepliesDtl());
        }
        return "board/read";
    }

    @PostMapping("/read/{id}")
    @ResponseBody
    public ResponseEntity<Page<BoardReplyDto>> read( @PathVariable Long id
                                                , @PageableDefault(page=1) Pageable pageable){


        Page<BoardReplyDto> Replies = boardReplyService.findReplies(pageable, id);
        ResponseEntity<Page<BoardReplyDto>> responseEntity= new ResponseEntity<>(Replies, HttpStatus.OK);

        return responseEntity;
    }



    //@PageableDefault(page =1) :page는 기본으로 1페이지를 보여준다.
    //list.html로부터 페이지 번호 받음
    @GetMapping("/posts/paging")
    public String getList(@PageableDefault(page=1) Pageable pageable, Model model, String keyword){


        Page<BoardMany> boardpages = boardService.paging(pageable, keyword);


        /*
        * blockLimit : page 개수 설정
        * 현재 사용자가 선택한 페이지 앞 뒤로 n페이지씩만 보여준다.
        *
        * 현재 사용자가 4페이지라면
        * 1, 2, 3, (4), 5, 6,..., (4+n-1)
        *
        * */


        int blockLimit = 3;
        int startPage = (((int)Math.ceil(((double)pageable.getPageNumber()/blockLimit))-1)*blockLimit+1);
        int endPage = Math.min((startPage + blockLimit - 1), boardpages.getTotalPages());

        model.addAttribute("boardpages", boardpages);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        return "board/list"; // (/board/list)도 된다.
    }

    @GetMapping(value = "/posts/paging/search")
    public String getSearchList(@PageableDefault(page=1) Pageable pageable, Model model, String keyword ){

        System.out.println(keyword);
        Page<BoardMany> boardpages = boardService.paging(pageable, keyword);


        int blockLimit = 3;
        int startPage = (((int)Math.ceil(((double)pageable.getPageNumber()/blockLimit))-1)*blockLimit+1);
        int endPage = Math.min((startPage + blockLimit - 1), boardpages.getTotalPages());

        model.addAttribute("boardpages", boardpages);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        return "board/searchlist"; // (/board/list)도 된다.
    }



    @PostMapping("remove")
    public String remove(HttpServletRequest request,String user, Long id, Model model){
        //remove 파라미터에 HttpSession session으로 가져와도 ㄱㅊ.
        HttpSession session =request.getSession();


        //현재 user id 와 게시글 작성한 유저 id가 같은지 확인
        if(user.equals(session.getAttribute("id"))){
            boardService.remove(id);
            return "redirect:/board/posts/paging";
        }

        model.addAttribute("msg","삭제 권한이 없습니다.");
        return "redirect:/board/read/" + id;
    }


    @GetMapping("/write")
    public String show(Model model, HttpServletRequest request){
        BoardMany board = new BoardMany();
        User user;
        String keyword = "";

        HttpSession session = request.getSession();
        Enumeration<String> attributes = session.getAttributeNames();
        while (attributes.hasMoreElements()) {
            keyword = attributes.nextElement();
            if(keyword.equals("id")) {
                break;
            }
        }

        if (keyword.isEmpty()){
            System.out.println("로그인 페이지로.");
            return "redirect:/login/login?URL=/board/write";
        }

        String id = (String)session.getAttribute(keyword);
        System.out.println("id:" + id + ";");

        user = boardService.findUser(id);

        //필요한가
        if(user == null){
            return "redirect:/login/login";
        }
        System.out.println(user);



        board.setUser(user);
        model.addAttribute("board", board);
        return "board/write";
    }

    @PostMapping("/write")
    public String write(BoardMany board){

        boardService.write(board);

        return "redirect:/board/posts/paging";

    }



    @GetMapping("/modify")
    public String modify(Long id, Model model){
        BoardMany board = boardService.read(id);
        model.addAttribute("board", board);
        return "board/write";
    }

    @PostMapping("/modify")
    public String modify(BoardMany board){
        boardService.modify(board);
        return "redirect:/board/list";
    }

    @PostMapping("/reply/save")
    public @ResponseBody ResponseEntity<List<BoardReplyDto>> saveReply(@RequestBody BoardReplyDto boardReplyDto){

        //RequestBody 빼면 사라짐.
        boardReplyDto.setReplyId(null);
        boardReplyService.save(boardReplyDto);

        List<BoardReplyDto> Replies =boardReplyService.getReplies(boardReplyDto.getBoardId());

        return ResponseEntity.ok(Replies);

//        Page<BoardReplyDto> Replies = boardReplyService.findReplies(pageable, boardReplyDto.getBoardId());
//        ResponseEntity<Page<BoardReplyDto>> responseEntity= new ResponseEntity<>(Replies, HttpStatus.OK);

//        return responseEntity;
    }
    @DeleteMapping("/reply")
    public @ResponseBody ResponseEntity<List<BoardReplyDto>> deleteReply(@RequestBody ReplyDeleteDto replyDeleteDto){
        boardReplyService.delete(replyDeleteDto.getReplyId(), replyDeleteDto.getUserId());
        List<BoardReplyDto> Replies =boardReplyService.getReplies(replyDeleteDto.getBoardId());
        System.out.println("boardManyId : "+replyDeleteDto.getBoardId());
        System.out.println("-----------------------------------------------------------------------------------------");
        Replies.forEach(System.out::println);

        return ResponseEntity.ok(Replies);

    }

}
