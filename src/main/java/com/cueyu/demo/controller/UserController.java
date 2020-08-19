package com.cueyu.demo.controller;

import com.cueyu.demo.entity.User;
import com.cueyu.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    public User getUser(int id){
        System.out.println(id);
        return userService.selectUserbyId(id);
    }

//    用户注册控制器
    @PostMapping("/addUser")
    public String addUser(HttpServletRequest request){
        User user = new User();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String iscuit = request.getParameter("iscuit");

        if (iscuit != null) {
            user.setIscuit(1);
        }else {
            user.setIscuit(0);
        }

//        密码为空
        if (StringUtils.isEmpty(password) || StringUtils.isEmpty(username)){
            return "password or username cannot be null";
        }
        user.setUsername(username);
        user.setPassword(password);
        int result = userService.registerUser(user);
        System.out.println(result);
        if (result == 1){
            return "register succeed";
        }else {
            return "something wrong";
        }
    }

//    登陆控制器
    @PostMapping("/login")
    public String login(HttpServletRequest request, HttpSession session){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            return "请输入用户名和密码！";
        }

        User user = userService.selectUserbyName(username);
        if (password.equals(user.getPassword())){
            session.setAttribute("user",username);
            return "login succeed";
        }else{
            return "login failed";
        }
    }

}
