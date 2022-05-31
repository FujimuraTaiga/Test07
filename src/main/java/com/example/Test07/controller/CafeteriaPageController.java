package com.example.Test07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "cafeteria")
public class CafeteriaPageController {

    @RequestMapping(value = "menu")
    String list(){
        return "cafeteria_menu.html";
    }

    @RequestMapping(value = "ranking")
    String ranking(){
        return "cafeteria_ranking.html";
    }
}
