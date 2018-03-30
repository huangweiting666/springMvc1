package com.newer.test;

import com.newer.bean.Userinfo;
import com.newer.service.UserinfoService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserinfoTest {
    @Test
    public  void Test(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserinfoService service = ctx.getBean("userInfoService",UserinfoService.class);
        Userinfo userinfo = new Userinfo();
        userinfo.setUserName("rose");
        userinfo.setUserPwd("111111");
        System.out.println(service.login(userinfo));
    }
}
