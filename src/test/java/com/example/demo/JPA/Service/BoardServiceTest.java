package com.example.demo.JPA.Service;

import com.example.demo.JPA.Entity.BoardMany;
import com.example.demo.JPA.Entity.User;
import com.example.demo.JPA.Repository.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BoardServiceTest {

    @Autowired
    BoardService boardService;

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        for(Long i =1L; i<=10L; i++){
            BoardMany board = new BoardMany();
            board.setId(i);
            board.setTitle("title"+i);
            board.setContent("Content"+i);
            User user = new User();
            user.setId("asdf");
            userRepository.save(user);



            board.setUser(user);
            board.setViewCnt(0L);
            board.setUpDate(new Date());
            board.setInDate(new Date());
            boardService.write(board);
        }
    }

//    @Test
//    @Order(1)
//    @DisplayName("가져오기")
//    public void getListTest(){
//        List<BoardMany> boards = boardService.g();
//        System.out.println("boards = " + boards);
//        assertEquals(boards.size(), 10);
//    }


    @Test
    @Order(2)
    @DisplayName("쓰기")
    public void writeAndread(){
        User user = new User();
        user.setId("bbb");
        userRepository.save(user);

        BoardMany board = new BoardMany();
        board.setId(11L);
        board.setTitle("title1");
        board.setContent("Content1");
        board.setUpDate(new Date());
        board.setInDate(new Date());
        board.setViewCnt(0L);
        board.setUser(user);
        boardService.write(board);


        BoardMany bm= boardService.read(11L);
        assertNotNull(bm);
        assertEquals(bm.getTitle(), board.getTitle());
        assertEquals(bm.getContent(), board.getContent());

    }

    @Test
    @Order(3)
    @DisplayName("수정")
    public void modifyTest(){
        BoardMany board = boardService.read(2L);
        board.setTitle("modified-title");
        board.setContent("modified-content");
        boardService.modify(board);

        BoardMany bm= boardService.read(2L);
        assertEquals(bm.getTitle(), board.getTitle());
        assertEquals(bm.getContent(), board.getContent());
    }

    @Test
    @Order(4)
    @DisplayName("삭제")
    public void deleteTest(){

        Long id = 1L;
        assertTrue(boardService.read(id)!=null);
        boardService.remove(id);
        BoardMany bm= boardService.read(id);
        assertTrue(bm == null);
    }

}