package com.example.Test07.controller.C1_UI_controller.Cafeteria;

import com.example.Test07.repository.C8_Cafeteria.CafeteriaDAO;
import com.example.Test07.repository.C8_Cafeteria.CafeteriaPost;
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
        model.addAttribute("menu",service.findMenuById(menuId));
        model.addAttribute("posts",service.readPost(menuId));
        model.addAttribute("evaluation","★4.9");    //仮実装。投稿DBから評価の平均を取ってくる。
        return "FoodDetail.html";
    }

    @RequestMapping(value = "/review")
    String review(Model model, @RequestParam String menuId){
        model.addAttribute("menuId",menuId);
        return "FoodReviewComment.html";
    }

    @RequestMapping(value = "/post")
    String post(RedirectAttributes redirectAttributes, @RequestParam String menuId, @RequestParam int star, @RequestParam String comment){
        String postId = UUID.randomUUID().toString().substring(0,8);
        service.createPost(postId,menuId,star,comment);

        redirectAttributes.addAttribute("menuId",menuId);
        return "redirect:/cafeteria/detail";
    }
}
