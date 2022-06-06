package com.example.Test07.controller.C1_UI_controller.Class;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/class")
@Controller
public class ClassFormPageController {
    @RequestMapping(value = "/list")
    String detail(){
        return "ClassList.html";
    }
}
