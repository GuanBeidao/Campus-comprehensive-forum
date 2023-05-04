package com.gbd.forum.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gbd.forum.entity.Picture;
import com.gbd.forum.mapper.PictureMapper;
import com.gbd.forum.service.PictureService;
import org.springframework.stereotype.Service;

/**
 * (Picture)表服务实现类
 *
 * @author makejava
 * @since 2023-05-03 12:06:05
 */
@Service("pictureService")
public class PictureServiceImpl extends ServiceImpl<PictureMapper, Picture> implements PictureService {

}

