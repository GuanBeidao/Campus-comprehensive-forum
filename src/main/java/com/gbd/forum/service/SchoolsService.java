package com.gbd.forum.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gbd.forum.entity.Schools;
import com.gbd.forum.entity.dto.SchoolDto;

import java.util.List;


/**
 * (Schools)表服务接口
 *
 * @author makejava
 * @since 2023-04-09 23:31:57
 */
public interface SchoolsService extends IService<Schools> {

    List<SchoolDto> getAllSchool();
}

