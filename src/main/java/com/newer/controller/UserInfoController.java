package com.newer.controller;

import com.newer.bean.Userinfo;
import com.newer.dao.UserinfoMapper;
import com.newer.service.UserinfoService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.BagUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

@Controller
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    private UserinfoService userinfoService;

    @RequestMapping("/login")
    public String login(Userinfo userinfo, HttpSession session){
        Userinfo user = userinfoService.login(userinfo);
        if(user == null){
            session.setAttribute("msg","用户名或密码错误！");
            return "login";
        }else{
            session.setAttribute("loginer",user);
            return "redirect:/index.jsp";
        }
    }
    @RequestMapping("/changePwd")
    public void changePwd(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException, ServletException {
        //获取了响应对象后，控制器方法返回值必须定义成void
        Userinfo userinfo = new Userinfo();
        BeanUtils.populate(userinfo,request.getParameterMap());
         if(userinfoService.updatePwd(userinfo)>0){
             response.sendRedirect("../suc.jsp");
         }else {
             request.getRequestDispatcher("../index.jsp").forward(request,response);
         }
    }
    @RequestMapping("/checkName")
    public void checkName(String username,PrintWriter printWriter){
        if(userinfoService.findName(username)==0){
            printWriter.print("用户名可以使用！");
        }else {
            printWriter.print("用户名已被注册！");
        }
    }
}
