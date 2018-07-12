package com.example.shiro.dao;

import com.example.shiro.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class ShiroDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User findUserByUserName(String userName) {
        String sql = "select * from user where user_name = ?";
        List<User> list = jdbcTemplate.query(sql, new Object[]{userName}, new BeanPropertyRowMapper<>(User.class));
        return list.size() == 0 ? null : list.get(0);
    }

    public Set<String> findRoleNameListByUserId(Integer userId) {
        String sql = "select role.name from role inner join user_role u_r on role.id = u_r.role_id where u_r.user_id = ?";
        List<String> list = jdbcTemplate.queryForList(sql, new Object[]{userId}, String.class);
        return new HashSet<>(list);
    }

    public Set<String> findPermissionNameListByUserId(Integer userId) {
        String sql = "select p.name from user_role u_r inner join role_permission r_p on u_r.role_id = r_p.role_id inner join permission p on r_p.permission_id = p.id where u_r.user_id = ?";
        List<String> list = jdbcTemplate.queryForList(sql, new Object[]{userId}, String.class);
        return new HashSet<>(list);
    }

}