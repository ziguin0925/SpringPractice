package com.example.demo.JPA;

import com.example.demo.JPA.Entity.Board;
import com.example.demo.JPA.Entity.BoardMany;
import com.example.demo.JPA.Entity.User;
import com.example.demo.JPA.Service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }
    @GetMapping("/")
    public String  index(){
        return "index";
    }

    @GetMapping("/read")
    public String read(Long id, Model model){
        BoardMany boardMany = boardService.read(id);
        model.addAttribute("board", boardMany);
        return "board/read";
    }

    @GetMapping("/list")
    public String getList(Model model){
        List<BoardMany> list = boardService.getList();
        model.addAttribute("list", list);

        return "board/list"; // (/board/list)도 된다.
    }


    @PostMapping("remove")
    public String remove(Long id, Model model){
        boardService.remove(id);
        return "redirect:/board/list";
    }


    @GetMapping("/write")
    public String show(Model model){
        BoardMany board = new BoardMany();
        User user = new User();
        user.setId("demoApplication");//나중에는 user아이디 받기.
        board.setUser(user);
        model.addAttribute("board", board);
        return "board/write";
    }

    @PostMapping("/write")
    public String write(BoardMany board){

        board.setId(11L);//나중에는 AutoIncrement 사용하기
        User user = new User();
        user.setId("demoApplication");
        board.setUser(user);
        board.setUpDate(new Date());
        board.setViewCnt(0L);
        board.setInDate(new Date());

        boardService.write(board);

        return "redirect:/board/list";

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
}
