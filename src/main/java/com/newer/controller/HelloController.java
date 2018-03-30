package com.newer.controller;

import com.newer.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello被执行");
        return "index";
    }
    @RequestMapping("/login")
    public  String login(String username, String pwd){
        System.out.println(username+":"+pwd);
        return "jsp/hello";
    }
    @RequestMapping("/login1")
    public  String login1(User user){
        System.out.println(user.getUsername()+":"+user.getPwd());
        return "jsp/hello";
    }
    @RequestMapping("/getUser")
    public ModelAndView getUser(){
        ModelAndView mav = new ModelAndView();
        User user = new User();
        user.setUserid(1);
        user.setUsername("laoxie");
        user.setPwd("111111");
        mav.addObject("user",user);
        //内部转发按照视图解析器生成视图路径
        //mav.setViewName("jsp/hello");
        //重定向不按照视图解析器的配置路径跳转
        //重定向以/开头，从当前项目应用上下文根目录开始的绝对路径
        mav.setViewName("redirect:/jsp/hello.jsp");
        return mav;
    }
}
