package com.example.Test07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

/**
 * 2022/06/21
 * http://{domain}/のリクエストに対応して処理をするクラス。
 */

@Controller
@RequestMapping(value = "/")
public class MainPageController {

    /**
     * http://{domain}/のリクエストに対応する。
     * @param model
     * @return メインページを表示する
     */
    @RequestMapping(value = "")
    String hello(Model model){
        return "MainMenu.html";
    }
}
