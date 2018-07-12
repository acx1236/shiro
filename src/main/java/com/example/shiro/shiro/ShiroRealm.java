package com.example.shiro.shiro;

import com.example.shiro.model.User;
import com.example.shiro.service.IShiroService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private IShiroService shiroService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("————权限认证————");
        User user = (User) principalCollection.getPrimaryPrincipal();
        Set<String> roleNameList = shiroService.findRoleNameListByUserId(user.getId());
        user.setRoles(roleNameList);
        Set<String> permissionNameList = shiroService.findPermissionNameListByUserId(user.getId());
        user.setPermissions(permissionNameList);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roleNameList);
        info.setStringPermissions(permissionNameList);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("————身份认证方法————");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName = token.getUsername();
        System.out.println(userName);
        User user = shiroService.findUserByUserName(userName);
        if (user == null) {
            throw new UnknownAccountException(userName);
        }
        return new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(userName + "shiro"), getName());
    }
}