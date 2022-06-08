package com.example.Test07.controller.C4_Class;

import com.example.Test07.repository.C9_Class.Class;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/class")
@Controller
public class ClassFormPageController {
    @RequestMapping(value = "/list")
    String list(Model model){
        List<Class> classes = new ArrayList<>();
        classes.add(new Class("00000001","工学部","情報工学科","高度情報演習IB"));
        model.addAttribute("classes",classes);
        return "ClassList.html";
    }

    @RequestMapping(value = "/detail")
    String detail(Model model,@RequestParam String classId){
        Class _class = new Class("00000001","工学部","情報工学科","高度情報演習IB");
        model.addAttribute("class",_class);
        return "ClassDetail.html";
    }

    @RequestMapping(value = "/review")
    String review(){return "ClassReviewComment.html";}

    @RequestMapping(value = "/post")
    String post(){return "redirect:/detail";}
}
