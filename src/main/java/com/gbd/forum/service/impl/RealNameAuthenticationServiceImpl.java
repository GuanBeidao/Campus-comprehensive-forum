package com.gbd.forum.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gbd.forum.entity.RealNameAuthentication;
import com.gbd.forum.mapper.RealNameAuthenticationMapper;
import com.gbd.forum.service.RealNameAuthenticationService;
import org.springframework.stereotype.Service;

/**
 * (RealNameAuthentication)表服务实现类
 *
 * @author makejava
 * @since 2023-04-09 23:32:28
 */
@Service("realNameAuthenticationService")
public class RealNameAuthenticationServiceImpl extends ServiceImpl<RealNameAuthenticationMapper, RealNameAuthentication> implements RealNameAuthenticationService {

}

