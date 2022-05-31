package com.example.Test07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping(value = "/")
public class MainPageController {

    @RequestMapping(value = "")
    String hello(Model model){
        return "main.html";
    }

    @RequestMapping(value = "cafeteria")
    String cafeteria(){
        return "cafeteria_top.html";
    }

    @RequestMapping(value = "course")
    String course(){
        return "course_top.html";
    }

    @RequestMapping(value = "thread")
    String thread(){
        return "thread_top.html";
    }
}
