package com.example.Test07.controller.C1_UI_controller.Cafeteria;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value = "/detail")
@Controller
public class CafeteriaDetailPageController {
    @RequestMapping(value = "/review")
    String review(@RequestParam String id){
        return "FoodReviewComment.html";
    }
}
