package com.gbd.forum.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gbd.forum.entity.StudentIdentity;
import com.gbd.forum.mapper.StudentIdentityMapper;
import com.gbd.forum.service.StudentIdentityService;
import org.springframework.stereotype.Service;

/**
 * (StudentIdentity)表服务实现类
 *
 * @author makejava
 * @since 2023-04-09 23:31:32
 */
@Service("studentIdentityService")
public class StudentIdentityServiceImpl extends ServiceImpl<StudentIdentityMapper, StudentIdentity> implements StudentIdentityService {

}

