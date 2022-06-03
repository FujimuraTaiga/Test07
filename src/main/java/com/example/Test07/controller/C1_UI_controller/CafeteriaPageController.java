package com.example.Test07.controller.C1_UI_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "cafeteria")
public class CafeteriaPageController {

    @RequestMapping(value = "detail")
    String list(){
        return "FoodDetail.html";
    }
}
