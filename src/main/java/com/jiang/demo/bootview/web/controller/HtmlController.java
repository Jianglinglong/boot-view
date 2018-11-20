package com.jiang.demo.bootview.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * @author Jiang
 * @date 2018/11/20
 * @time 11:47
 */
@Controller
public class HtmlController {
    @GetMapping("/index.html")
    public String index(HttpSession session) {
        System.out.println(session.getId());
        return "html/index";
    }
}
