package com.example.Test07.controller.C6_NoticeBoard;

import com.example.Test07.repository.C10_NoticeBoard.NoticeBoard;
import com.example.Test07.repository.C10_NoticeBoard.NoticeBoardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping(value = "/notice-board")
@Controller
public class NoticeBoardController {
    NoticeBoardDAO dao;
    @Autowired
    NoticeBoardController(NoticeBoardDAO dao){ this.dao = dao; }

    /*スレッド一覧表示*/
    @RequestMapping(value = "")
    String top(Model model){
        model.addAttribute("noticeList",dao.readNoticeBoardList());
        return "NoticeList.html";
    }
    /*スレッドの詳細の表示*/
    @RequestMapping(value = "/detail")
    String detail(Model model, @RequestParam String noticeId){
        model.addAttribute("notice",dao.findNoticeBoardById(noticeId));
        return "NoticeDetail.html";
    }

    @RequestMapping(value = "/review")
    String review(Model model,@RequestParam String noticeId){
        model.addAttribute("noticeId",noticeId);
        return "Notice9999.html";
    }

    @RequestMapping(value = "/post")
    String post(RedirectAttributes redirectAttributes,@RequestParam String noticeId){
        dao.createPost(noticeId);
        redirectAttributes.addAttribute("noticeId",noticeId);
        return "redirect:/detail";
    }



}
