package com.jiang.demo.bootview.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Jiang
 * @date 2018/11/20
 * @time 11:47
 */
@Controller
public class JavascriptController {
    @GetMapping(value = "/index.js",produces = "application/javascript")
    public String index(Model model){
        model.addAttribute("code","code");
        return "index.js";
    }
}
