package com.example.demo.JPA;

import com.example.demo.JPA.Entity.BoardMany;
import com.example.demo.JPA.Service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/board/list")
    public String getList(Model model){
        List<BoardMany> list = boardService.getList();
        model.addAttribute("list", list);

        return "/board/list";
    }
}
