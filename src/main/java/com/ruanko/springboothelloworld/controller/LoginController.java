package com.ruanko.springboothelloworld.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ruanko.springboothelloworld.entity.User;
import com.ruanko.springboothelloworld.service.UserService;

import javax.annotation.Resource;

@Controller
@Slf4j
public class LoginController {
    //将Service注入Web层
    @Resource
    UserService userService;

    //实现登录
    @RequestMapping("/login")
    public String show(){
        return "login";
    }

    @RequestMapping(value = "/loginIn",method = RequestMethod.POST)
    public String login(String username,String password){
        User userBean = userService.LoginIn(username, password);
        log.info("username"+username);
        log.info("password"+password);

        if(userBean!=null){
            return "success";
        }else {
            return "error";
        }
    }
    @RequestMapping("/index.html")
    public String mainPage(){
        return "index";
    }

    @RequestMapping("/signup")
    public String disp(){
        return "signup";
    }

    //实现注册功能
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String signUp(String username,String password){
        userService.Insert(username, password);
        return "successSingup";
    }

}
