package com.example.Test07.controller.C1_UI_controller.Cafeteria;

import com.example.Test07.service.C2_CafeteriaPost.CafeteriaPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
@RequestMapping(value = "/cafeteria")
public class CafeteriaPageController {

    CafeteriaPostService service;

    @Autowired
    CafeteriaPageController(CafeteriaPostService service){this.service = service;}

    @RequestMapping(value = "/detail")
    String list(Model model, @RequestParam String menuId){
        model.addAttribute("menu",service.findMenuById(menuId));    //DBからメニューデータを取得してhtmlに反映させる。
        model.addAttribute("posts",service.readPost(menuId));       //DBから投稿データを取得してhtmlに反映させる。
        model.addAttribute("evaluation","★4.9");        //仮実装。投稿DBから評価の平均を取ってくる。
        return "FoodDetail.html";
    }

    @RequestMapping(value = "/review")
    String review(Model model, @RequestParam String menuId){
        model.addAttribute("menuId",menuId);
        return "FoodReviewComment.html";
    }

    @RequestMapping(value = "/post")
    String post(RedirectAttributes redirectAttributes, @RequestParam String menuId, @RequestParam int star, @RequestParam String comment){

        String postId = UUID.randomUUID().toString().substring(0,8);        //32文字のIDを生成、先頭の8文字を切り取って投稿IDにする。
        service.createPost(postId,menuId,star,comment);

        redirectAttributes.addAttribute("menuId",menuId);      //detailにリダイレクトする時に必要なパラメータを用意
        return "redirect:/cafeteria/detail";                                //リダイレクト
    }
}
