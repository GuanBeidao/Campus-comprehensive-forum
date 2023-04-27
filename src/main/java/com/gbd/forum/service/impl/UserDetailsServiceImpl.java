package com.gbd.forum.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gbd.forum.entity.LoginUser;
import com.gbd.forum.entity.User;
import com.gbd.forum.mapper.MenuMapper;
import com.gbd.forum.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersService usersService;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 根据用户名查询用户数据
        LambdaQueryWrapper<User> lambdaQueryWrapper = Wrappers.<User>lambdaQuery().eq(User::getUsername, username);
        User user = usersService.getOne(lambdaQueryWrapper);

        // 如果查询不到数据，说明用户名或者密码错误，直接抛出异常
        if (user == null) {
            throw new RuntimeException("用户名或者密码错误");
        }

        // 将查询到的对象转换成Spring Security所需要的UserDetails对象
        List<String> permissions = menuMapper.findUserMenuById(user.getId());
        return new LoginUser(user, permissions);

    }

}
