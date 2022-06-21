package com.example.Test07.controller.C4_Class;

import com.example.Test07.repository.C9_Class.ClassPost;
import com.example.Test07.service.ClassService.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

/**
 * 2022/06/21
 * 授業に関するhttpリクエストに対応するクラス。
 * @author FujimuraTaiga
 * ver. 1.0.0
 */

@Controller
@RequestMapping(value = "/class")
public class ClassController {

    ClassService service;

    @Autowired
    ClassController(ClassService service){ this.service = service; }

    /**
     * ClassDAOから授業情報のリストを取得し、htmlにそのデータを渡す。
     * @param model 
     * @return 授業一覧ページを表示する。
     */
    @RequestMapping(value = "")
    String top(Model model){
        model.addAttribute("classList", service.readClassMenu());
        return "ClassList.html";
    }

    /**
     * ClassDAOからclassIdの一致する授業情報を取得し、htmlにそのデータを渡す。
     * @param model 
     * @param classId 授業を識別するId。リクエストパラメータとして受け取る。
     * @return 授業詳細ページを表示する。
     */
    @RequestMapping(value = "/detail")
    String list(Model model,@RequestParam String classId) {
        model.addAttribute("class", service.findClassMenuById(classId));
        model.addAttribute("posts", service.readClassPost(classId));       //DBから投稿データを取得してhtmlに反映させる。
        model.addAttribute("evaluation", service.findClassEvaluationAVG(classId));        //仮実装。投稿DBから評価の平均を取ってくる。        return "ClassDetail.html";
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
    String post(RedirectAttributes redirectAttributes,@RequestParam String classId, @RequestParam int star, @RequestParam String comment){
        String postId = UUID.randomUUID().toString().substring(0,8);        //32文字のIDを生成、先頭の8文字を切り取って投稿IDにする。
        service.createClassPost(new ClassPost(postId,classId,star,comment));
        redirectAttributes.addAttribute("classId",classId);
        return "redirect:/class/detail";
    }
}
