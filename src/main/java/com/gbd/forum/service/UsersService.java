package com.gbd.forum.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gbd.forum.entity.User;
import com.gbd.forum.entity.vo.LoginVo;
import com.gbd.forum.entity.vo.RegisterVo;

import java.util.Map;


/**
 * (Users)表服务接口
 *
 * @author makejava
 * @since 2023-04-09 23:12:17
 */
public interface UsersService extends IService<User> {

    void register(RegisterVo registerVo);

    String lgoin(LoginVo loginVo);

    Map<String, Object> getInfo();
}

