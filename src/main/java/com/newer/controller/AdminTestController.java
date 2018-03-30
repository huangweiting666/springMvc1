package com.newer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/admin")
@SessionAttributes("/user1")
public class AdminTestController {
    @RequestMapping("testError")
    public String testError(){
        int x=5/0;
        return "index";
    }
    @ExceptionHandler
    public String HandleExce(Exception ex){
        return "error";
    }
}
