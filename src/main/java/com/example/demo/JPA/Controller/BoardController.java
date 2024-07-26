package com.example.demo.JPA.Controller;

import com.example.demo.JPA.Entity.BoardMany;
import com.example.demo.JPA.Entity.User;
import com.example.demo.JPA.Service.BoardService;
import com.example.demo.JPA.Service.loginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Enumeration;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private final BoardService boardService;

    @Autowired
    loginService ls;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/read")
    public String read(Long id, Model model){
        BoardMany boardMany = boardService.read(id);
        model.addAttribute("board", boardMany);
        return "board/read";
    }

    //@PageableDefault(page =1) :page는 기본으로 1페이지를 보여준다.
    @GetMapping("/posts/paging")
    public String getList(@PageableDefault(page=1) Pageable pageable, Model model ){
        Page<BoardMany> boardpages = boardService.paging(pageable);


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


    @PostMapping("remove")
    public String remove(Long id, Model model){
        boardService.remove(id);
        return "redirect:/board/posts/paging";
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

}
