package com.example.Test07.controller;

import com.example.Test07.repository.C8_Cafeteria.CafeteriaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping(value = "/")
public class MainPageController {
    private final CafeteriaDAO cafeteriaDAO;

    @Autowired
    MainPageController(CafeteriaDAO cafeteriaDAO){this.cafeteriaDAO = cafeteriaDAO;}

    @RequestMapping(value = "")
    String hello(Model model){
        return "MainMenu.html";
    }

    @RequestMapping(value = "cafeteria")
    String cafeteria(Model model){
        model.addAttribute("menuList",cafeteriaDAO.readMenu());
        return "FoodList.html";
    }

    @RequestMapping(value = "class")
    String course(){
        return "ClassFirmInput.html";
    }

    @RequestMapping(value = "thread")
    String thread(){
        return "NoticeBoardList.html";
    }
}
