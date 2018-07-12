package com.example.shiro.service;

import com.example.shiro.model.User;

import java.util.Set;

public interface IShiroService {

    User findUserByUserName(String userName);

    Set<String> findRoleNameListByUserId(Integer userId);

    Set<String> findPermissionNameListByUserId(Integer userId);

}
