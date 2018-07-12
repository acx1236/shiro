package com.example.shiro.service.impl;

import com.example.shiro.dao.ShiroDao;
import com.example.shiro.model.User;
import com.example.shiro.service.IShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ShiroServiceImpl implements IShiroService {

    @Autowired
    private ShiroDao shiroDao;

    @Override
    public User findUserByUserName(String userName) {
        return shiroDao.findUserByUserName(userName);
    }

    @Override
    public Set<String> findRoleNameListByUserId(Integer userId) {
        return shiroDao.findRoleNameListByUserId(userId);
    }

    @Override
    public Set<String> findPermissionNameListByUserId(Integer userId) {
        return shiroDao.findPermissionNameListByUserId(userId);
    }

}
