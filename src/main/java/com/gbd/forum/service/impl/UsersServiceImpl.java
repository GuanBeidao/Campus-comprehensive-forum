package com.gbd.forum.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gbd.forum.entity.LoginUser;
import com.gbd.forum.entity.User;
import com.gbd.forum.entity.dto.UserDto;
import com.gbd.forum.entity.vo.LoginVo;
import com.gbd.forum.entity.vo.RegisterVo;
import com.gbd.forum.enums.HttpCodeEnum;
import com.gbd.forum.exception.SystemException;
import com.gbd.forum.mapper.UsersMapper;
import com.gbd.forum.service.UsersService;
import com.gbd.forum.utils.BeanCopyUtils;
import com.gbd.forum.utils.JwtUtil;
import com.gbd.forum.utils.RedisCache;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * (Users)表服务实现类
 *
 * @author makejava
 * @since 2023-04-09 23:12:17
 */
@Service("usersService")
public class UsersServiceImpl extends ServiceImpl<UsersMapper, User> implements UsersService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RedisCache redisCache;

    @Override
    public void register(RegisterVo registerVo) {
        User user = new User();
        BeanUtils.copyProperties(registerVo, user);
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, user.getUsername());
        boolean exists = this.baseMapper.exists(wrapper);
        if (exists) {
            throw new SystemException(HttpCodeEnum.REGISTER_FAIL_ACCOUNT);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setAvatar("https://gbd-forum.oss-cn-beijing.aliyuncs.com/default/avatar/avatar.png");
        user.setIsStudent(0);
        user.setIsRealName(0);
        this.baseMapper.insert(user);
    }

    @Override
    public String lgoin(LoginVo user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        if (Objects.isNull(authenticate)){
            throw new RuntimeException("用户名或密码错误");
        }
        //获取userid生成token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        Long id = loginUser.getUser().getId();
        String jwt = JwtUtil.getJwtToken(String.valueOf(id));
        //把用户信息存入redis
        redisCache.setCacheObject("login:"+id,loginUser);
        return jwt;
    }

    @Override
    public Map<String, Object> getInfo() {
        Map<String, Object> map = new HashMap<>();
        LoginUser loginUser = (LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDto userDto = BeanCopyUtils.copyBean(loginUser.getUser(), UserDto.class);
        map.put("userInfo",userDto);
        map.put("permissions",loginUser.getPermissions());
        return map;
    }
}

