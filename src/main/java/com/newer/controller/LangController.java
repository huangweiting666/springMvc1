package com.newer.controller;

import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LangController {
    @RequestMapping("/toEmp")
    public String toEmp(){
        return "emp";
    }
}
