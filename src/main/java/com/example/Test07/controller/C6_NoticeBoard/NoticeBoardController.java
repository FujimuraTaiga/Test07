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

/**
 * 掲示板に関するhttpリクエストに対応するクラス。
 * @author YagetaSyogo
 */
@RequestMapping(value = "/notice")
@Controller
public class NoticeBoardController {
    NoticeBoardDAO dao;
    @Autowired
    NoticeBoardController(NoticeBoardDAO dao){ this.dao = dao; }

    /**
     * NoticeDAOから授業情報のリストを取得し、htmlにそのデータを渡す。
     * @param model
     * @return 掲示板一覧ページを表示する。
     */
    @RequestMapping(value = "")
    String top(Model model){
        model.addAttribute("noticeList",dao.readThread());
        return "NoticeBoardList.html";
    }

    /**
     * NoticeDAOからnoticeIdの一致する掲示板情報を取得し、htmlにそのデータを渡す。
     * @param model
     * @param noticeId 掲示板を識別するId。リクエストパラメータとして受け取る。
     * @return 掲示板詳細ページを表示する。
     */
    @RequestMapping(value = "/detail")
    String detail(Model model, @RequestParam String noticeId){
        model.addAttribute("noticeId",noticeId);
        model.addAttribute("postList",dao.readPost(noticeId));
        return "NoticeBoardDetail.html";
    }

    /**
     * 掲示板作成にアクセスする関数
     * @return 掲示板作成ページを表示する。
     */
    @RequestMapping(value = "/thread")
    String review(){
        return "NoticeBoardMake.html";
    }


    /*スレッドの新規作成*/
    /**
     * リクエストパラメータとしてtitleを受け取り、スレッドを新規作成する。
     * @param title 掲示板を識別するId。
     * @return 掲示板一覧ページへリダイレクトする。
     */
    @RequestMapping(value = "/make")
    String make(@RequestParam String title){
        String noticeId = UUID.randomUUID().toString().substring(0,8);
        dao.createThread(new NoticeBoard(noticeId,title));
        return "redirect:/notice";
    }

    /**
     * 掲示板のコメントの投稿処理を受け付ける。
     * @param redirectAttributes リダイレクト先が要求するパラメータを付加。
     * @param noticeId どの掲示板なのかをを識別するId。
     * @return 掲示板詳細ページへリダイレクトする。
     */
    @RequestMapping(value = "/post")
    String post(RedirectAttributes redirectAttributes,@RequestParam String noticeId,@RequestParam String comment){
        String postId = UUID.randomUUID().toString().substring(0,8);
        dao.createPost(new ThreadPost(postId,noticeId,comment));
        redirectAttributes.addAttribute("noticeId",noticeId);
        return "redirect:/notice/detail";
    }
}
