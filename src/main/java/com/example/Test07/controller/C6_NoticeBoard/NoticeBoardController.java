package com.example.Test07.controller.C6_NoticeBoard;

import com.example.Test07.repository.C10_NoticeBoard.NoticeBoard;
import com.example.Test07.repository.C10_NoticeBoard.NoticeBoardDAO;
import com.example.Test07.repository.C10_NoticeBoard.ThreadPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.naming.NoInitialContextException;

@Controller
@RequestMapping(value = "/thread")
public class NoticeBoardController {

    NoticeBoardDAO dao;

    @Autowired
    NoticeBoardController(NoticeBoardDAO dao){this.dao=dao;}

    @RequestMapping(value = "")
    String list(){
        dao.createPost(new ThreadPost("9999999","99","aaaaa"));
        dao.createThread(new NoticeBoard("222","44444"));
        System.out.println(dao.readThread());
        System.out.println(dao.readPost("0093"));
        return "NoticeBoardList.html";
    }
}
