package com.newer.controller;

import com.newer.bean.Userinfo;
import com.newer.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/test")
public class UserTestController {
    @Autowired
    private UserinfoService userinfoService;
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String findAll(ModelMap map){
        //ModelMap代表当前控制器能得到的模型数据
        List<Userinfo> list = userinfoService.findAll();
        map.put("users",list);
        return "list";
    }

    @RequestMapping(value = "/users/{userId:\\d+}/{userName}",method = RequestMethod.GET)
    public String findById(@PathVariable("userId") Integer userId,@PathVariable("usesrName") String userName){
        //PathVariable用于注解将指定路径变量的值注入对应方法参数
        System.out.println(userId);
        return "index";
    }
    @RequestMapping(value = "/p1",params = "username = admin")
    public String testParam(@RequestParam("username") String username){
        System.out.println(username);
        return "index";
    }
    @ModelAttribute("user1")
    public Userinfo getOneUser(){
        //ModelAttribute注解在方法上，方法没有， 方法没有RequestMapping注解
        //表示在当前控制器的任何方法前，先执行这个方法，将方法的返回值放入当前控制器类的ModelMap
        return userinfoService.findAll().get(0);
    }
    @ModelAttribute("/get1")
    public String getOneUser1(ModelMap map){
        Userinfo u1 = (Userinfo) map.get("user1");
        System.out.println(u1.getUserName());
        return "index";

    }

    @ModelAttribute("user1")
    @RequestMapping("/get1")
    public Userinfo get2(){
        //ModelAttribute注解在方法上，方法没有， 方法没有RequestMapping注解
        //表示在当前控制器的任何方法前，先执行这个方法，将方法的返回值放入当前控制器类的ModelMap
        return userinfoService.findAll().get(0);
    }
    @ResponseBody
    @RequestMapping("/allusers")
    public List<Userinfo> findAllJson(){
        //Responsebody用于将方法返回值自动转换成json对象返回前台
        return userinfoService.findAll();
    }

}
