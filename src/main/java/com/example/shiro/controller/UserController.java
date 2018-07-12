package com.example.shiro.controller;

import com.example.shiro.model.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @ResponseBody
    @RequestMapping("/createUser")
    @RequiresPermissions("新建用户")
    @RequiresRoles("管理员")
    public String createUser(User user) {
        System.err.println(user);
        return "success";
    }

    @RequestMapping("/testToLogin")
    public String testToLogin() {
        return "testToLogin";
    }

}