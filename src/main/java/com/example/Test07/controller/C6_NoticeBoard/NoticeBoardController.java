package com.example.Test07.controller.C6_NoticeBoard;

import com.example.Test07.repository.C10_NoticeBoard.NoticeBoard;
import com.example.Test07.repository.C10_NoticeBoard.NoticeBoardDAO;
import com.example.Test07.repository.C10_NoticeBoard.ThreadPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.AttributedString;
import java.util.UUID;

@RequestMapping(value = "/notice")
@Controller
public class NoticeBoardController {
    NoticeBoardDAO dao;
    @Autowired
    NoticeBoardController(NoticeBoardDAO dao){ this.dao = dao; }

    /*スレッド一覧表示*/
    @RequestMapping(value = "")
    String top(Model model){
        model.addAttribute("noticeList",dao.readThread());
        return "NoticeBoardList.html";
    }
    /*スレッドの詳細の表示*/
    @RequestMapping(value = "/detail")
    String detail(Model model, @RequestParam String noticeId){
        model.addAttribute("notice",dao.readPost(noticeId));
        return "NoticeBoardDetail.html";
    }
  
    @RequestMapping(value = "/thread")
    String review(){
        return "NoticeBoardMake.html";
    }

    /*スレッドの新規作成*/
    @RequestMapping(value = "/make")
    String make(@RequestParam String title){
        String noticeId = UUID.randomUUID().toString().substring(0,8);
        dao.createThread(new NoticeBoard(noticeId,title));
        return "redirect:/notice";
    }

    @RequestMapping(value = "/post")
    String post(RedirectAttributes redirectAttributes,@RequestParam String noticeId,@RequestParam String comment){
        String postId = UUID.randomUUID().toString().substring(0,8);
        dao.createPost(new ThreadPost(postId,noticeId,comment));
        redirectAttributes.addAttribute("noticeId",noticeId);
        return "redirect:/detail";
    }
}
