package com.example.Test07.controller.C4_Class;

import com.example.Test07.repository.C9_Class.ClassDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 授業に関するhttpリクエストに対応するクラス。
 * @author FujimuraTaiga
 */
@RequestMapping(value = "/class")
@Controller
public class ClassController {

    ClassDAO dao;

    @Autowired
    ClassController(ClassDAO dao){ this.dao = dao; }

    /**
     * ClassDAOから授業情報のリストを取得し、htmlにそのデータを渡す。
     * @param model 
     * @return 授業一覧ページを表示する。
     */
    @RequestMapping(value = "")
    String top(Model model){
        model.addAttribute("classList",dao.readClass());
        return "ClassList.html";
    }

    /**
     * ClassDAOからclassIdの一致する授業情報を取得し、htmlにそのデータを渡す。
     * @param model 
     * @param classId 授業を識別するId。リクエストパラメータとして受け取る。
     * @return 授業詳細ページを表示する。
     */
    @RequestMapping(value = "/detail")
    String detail(Model model,@RequestParam String classId){
        model.addAttribute("class",dao.findClassById(classId));
        return "ClassDetail.html";
    }

    /**
     * リクエストパラメータとしてclassIdを受け取り、それをhtmlに渡す。
     * @param model 
     * @param classId 授業を識別するId。
     * @return 授業評価＆コメントページを表示する。
     */
    @RequestMapping(value = "/review")
    String review(Model model, @RequestParam String classId){
        model.addAttribute("classId",classId);
        return "ClassReviewComment.html";
    }

    /**
     * 授業評価＆口コミの投稿処理を受け付ける。
     * @param redirectAttributes リダイレクト先が要求するパラメータを付加。
     * @param classId 授業を識別するId。
     * @return 授業詳細ページへリダイレクトする。
     */
    @RequestMapping(value = "/post")
    String post(RedirectAttributes redirectAttributes,@RequestParam String classId){
        dao.createPost();
        redirectAttributes.addAttribute("classId",classId);
        return "redirect:/detail";
    }
}
