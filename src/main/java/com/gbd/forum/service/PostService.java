package com.gbd.forum.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gbd.forum.entity.Post;
import com.gbd.forum.entity.dto.PostCardDto;

import java.io.Serializable;
import java.util.Map;


/**
 * (Post)表服务接口
 *
 * @author makejava
 * @since 2023-04-09 23:32:38
 */
public interface PostService extends IService<Post> {

    Page<PostCardDto> recommend(Integer pageNum, Integer pageSize, Long schoolId, Long partId);

    Page<Post> getPostByUserId(Integer pageNum, Integer pageSize, Long userId);

    Map<String,Object> getDetailById(Serializable id);
}

