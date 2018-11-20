package com.jiang.demo.bootview.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Jiang
 * @date 2018/11/20
 * @time 11:47
 */
@Controller
public class CssController {
    @GetMapping("/index.css")
    public String index(){

        return "index.css";
    }
}
