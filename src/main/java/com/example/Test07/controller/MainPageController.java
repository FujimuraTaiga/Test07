package com.example.Test07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping(value = "/")
public class MainPageController {

    @RequestMapping(value = "")
    String hello(Model model){
        return "MainMenu.html";
    }

    @RequestMapping(value = "thread")
    String thread(){
        return "NoticeBoardList.html";
    }
}
