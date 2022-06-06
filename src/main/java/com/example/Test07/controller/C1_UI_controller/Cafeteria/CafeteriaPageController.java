package com.example.Test07.controller.C1_UI_controller.Cafeteria;

import com.example.Test07.repository.C8_Cafeteria.CafeteriaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
