package com.example.Test07.controller.C2_Cafeteria;

import com.example.Test07.service.C2_CafeteriaPost.CafeteriaPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

/**
 * 2022/06/21
 * C2 学食コントローラ
 * http://{domain}/cafeteria/{something}のリクエストに対応するクラス
 * @author FujimuraTaiga
 * ver. 1.0.0
 */

@Controller
@RequestMapping(value = "/cafeteria")
public class CafeteriaController {

    CafeteriaPostService service;

    @Autowired
    CafeteriaController(CafeteriaPostService service){this.service = service;}

    /**
     * http://{domain}/cafeteriaに対応。
     * @param model
     * @return 学食メニュー一覧画面を表示する。
     */
    @RequestMapping(value = "")
    String top(Model model){
        model.addAttribute("menuList",service.readMenuRanking());
        return "FoodList.html";
    }

    /**
     * http://{domain}/cafeteria/detailに対応。
     * @param model
     * @param menuId メニューを識別するId
     * @return 学食メニュー詳細画面を表示する。
     */
    @RequestMapping(value = "/detail")
    String list(Model model, @RequestParam String menuId){
        model.addAttribute("menu",service.findMenuById(menuId));    //DBからメニューデータを取得してhtmlに反映させる。
        model.addAttribute("posts",service.readPost(menuId));       //DBから投稿データを取得してhtmlに反映させる。
        model.addAttribute("evaluation",service.findEvaluationAVG(menuId));        //仮実装。投稿DBから評価の平均を取ってくる。
        return "FoodDetail.html";
    }

    /**
     * http://{domain}/cafeteria/reviewに対応。
     * @param model
     * @param menuId メニューを識別するId
     * @return 学食評価＆口コミ画面を表示する。
     */
    @RequestMapping(value = "/review")
    String review(Model model, @RequestParam String menuId){
        model.addAttribute("menuId",menuId);
        return "FoodReviewComment.html";
    }

    /**
     * http://{domain}/cafeteria/postに対応。
     * @param redirectAttributes
     * @param menuId メニューを識別するためのId
     * @param star 評価の数値
     * @param comment コメント
     * @return 学食詳細画面へリダイレクトする。
     */
    @RequestMapping(value = "/post")
    String post(RedirectAttributes redirectAttributes, @RequestParam String menuId, @RequestParam int star, @RequestParam String comment){

        String postId = UUID.randomUUID().toString().substring(0,8);        //32文字のIDを生成、先頭の8文字を切り取って投稿IDにする。
        service.createPost(postId,menuId,star,comment);

        redirectAttributes.addAttribute("menuId",menuId);      //detailにリダイレクトする時に必要なパラメータを用意
        return "redirect:/cafeteria/detail";                                //リダイレクト
    }
}
