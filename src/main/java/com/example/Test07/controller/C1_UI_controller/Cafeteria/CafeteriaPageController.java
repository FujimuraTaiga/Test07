package com.example.Test07.controller.C1_UI_controller.Cafeteria;

import com.example.Test07.repository.C8_Cafeteria.CafeteriaDAO;
import com.example.Test07.repository.C8_Cafeteria.CafeteriaPost;
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

    CafeteriaDAO dao;

    @Autowired
    CafeteriaPageController(CafeteriaDAO dao){this.dao = dao;}

    @RequestMapping(value = "/detail")
    String list(Model model, @RequestParam String id){
        model.addAttribute("menu",dao.findMenuById(id));
        model.addAttribute("evaluation","★4.9");
        return "FoodDetail.html";
    }

    @RequestMapping(value = "/review")
    String review(Model model, @RequestParam String id){
        model.addAttribute("menuId",id);
        return "FoodReviewComment.html";
    }

    @RequestMapping(value = "/post")
    String post(RedirectAttributes redirectAttributes, @RequestParam String menuId, @RequestParam int star, @RequestParam String comment){
        String postId = UUID.randomUUID().toString().substring(0,8);
        dao.createPost(new CafeteriaPost(postId,menuId,star,comment));

        redirectAttributes.addAttribute("id",menuId);
        return "redirect:/cafeteria/detail";
    }
}
