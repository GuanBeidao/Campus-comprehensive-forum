package com.gbd.forum.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gbd.forum.entity.Schools;
import com.gbd.forum.entity.dto.SchoolDto;
import com.gbd.forum.mapper.SchoolsMapper;
import com.gbd.forum.service.SchoolsService;
import com.gbd.forum.utils.BeanCopyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * (Schools)表服务实现类
 *
 * @author makejava
 * @since 2023-04-09 23:31:57
 */
@Service("schoolsService")
public class SchoolsServiceImpl extends ServiceImpl<SchoolsMapper, Schools> implements SchoolsService {

    @Override
    public List<SchoolDto> getAllSchool() {
        List<Schools> schoolsList = list();
        List<SchoolDto> schoolDtos = BeanCopyUtils.copyBeanList(schoolsList, SchoolDto.class);
        return schoolDtos;
    }
}

