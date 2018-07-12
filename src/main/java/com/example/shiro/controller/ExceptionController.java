package com.example.shiro.controller;

import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(UnknownAccountException.class)
    public String handleAccountException(UnknownAccountException e) {
        return "错误的账号：" + e.getMessage();
    }

    @ExceptionHandler(IncorrectCredentialsException.class)
    public String handleIncorrectCredentialsException(IncorrectCredentialsException e) {
        System.out.println(e.getMessage());
        return "密码不正确。";
    }

    @ExceptionHandler(ExcessiveAttemptsException.class)
    public String handleExcessiveAttemptsException(ExcessiveAttemptsException e) {
        System.out.println(e.getMessage());
        return "登录失败次数过多。";
    }

    @ExceptionHandler(AuthorizationException.class)
    public String handleAuthorizationException(AuthorizationException e) {
        System.out.println(e.getMessage());
        return "没有权限访问。";
    }

}