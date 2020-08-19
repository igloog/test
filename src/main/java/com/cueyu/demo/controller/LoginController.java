package com.cueyu.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {

//  返回index模板
    @RequestMapping({"/","index"})
    public String index(){
        return "index";
    }


}
