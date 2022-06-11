package com.example.Test07.controller.C4_Class;

import com.example.Test07.repository.C9_Class.ClassDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value = "/class")
@Controller
public class ClassController {

    ClassDAO dao;

    @Autowired
    ClassController(ClassDAO dao){ this.dao = dao; }

    @RequestMapping(value = "")
    String top(Model model){
        model.addAttribute("classList",dao.readClass());
        return "ClassList.html";
    }

    @RequestMapping(value = "/detail")
    String detail(Model model,@RequestParam String classId){
        model.addAttribute("class",dao.findClassById(classId));
        return "ClassDetail.html";
    }

    @RequestMapping(value = "/review")
    String review(Model model, @RequestParam String classId){
        model.addAttribute("classId",classId);
        return "ClassReviewComment.html";
    }

    @RequestMapping(value = "/post")
    String post(){
        return "redirect:/detail";
    }
}
