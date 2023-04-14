package com.gbd.forum.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gbd.forum.entity.BaseUserInfo;
import com.gbd.forum.entity.Users;
import com.gbd.forum.entity.vo.LoginVo;
import com.gbd.forum.entity.vo.RegisterVo;
import com.gbd.forum.enums.HttpCodeEnum;
import com.gbd.forum.exception.SystemException;
import com.gbd.forum.mapper.UsersMapper;
import com.gbd.forum.service.UsersService;
import com.gbd.forum.utils.JwtUtil;
import com.gbd.forum.utils.RedisCache;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (Users)表服务实现类
 *
 * @author makejava
 * @since 2023-04-09 23:12:17
 */
@Service("usersService")
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {
    @Autowired
    private RedisCache redisCache;

    @Override
    public void register(RegisterVo registerVo) {
        Users user = new Users();
        BeanUtils.copyProperties(registerVo, user);
        LambdaQueryWrapper<Users> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Users::getUsername, user.getUsername());
        boolean exists = this.baseMapper.exists(wrapper);
        if (exists) {
            throw new SystemException(HttpCodeEnum.REGISTER_FAIL_ACCOUNT);
        }

        user.setAvatar("https://profile.csdnimg.cn/0/A/5/2_u014708644");
        user.setIsStudent(0);
        user.setIsRealName(0);
        this.baseMapper.insert(user);
    }

    @Override
    public String lgoin(LoginVo loginVo) {
        LambdaQueryWrapper<Users> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Users::getUsername, loginVo.getUsername());
        Users users = this.baseMapper.selectOne(wrapper);
        if (users == null) {
            throw new SystemException(HttpCodeEnum.LOGIN_ERROR);
        }
        String jwt = JwtUtil.getJwtToken(String.valueOf(users.getId()));
        redisCache.setCacheObject("login:", users.getId());
        System.out.println(users.getUsername());
        System.out.println(users.getId());
//        BaseUserInfo.setUser(users.getUsername(), String.valueOf(users.getId()));
        return jwt;
    }
}

