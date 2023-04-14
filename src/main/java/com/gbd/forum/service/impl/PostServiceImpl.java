package com.gbd.forum.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gbd.forum.entity.Post;
import com.gbd.forum.mapper.PostMapper;
import com.gbd.forum.service.PostService;
import org.springframework.stereotype.Service;

/**
 * (Post)表服务实现类
 *
 * @author makejava
 * @since 2023-04-09 23:32:38
 */
@Service("postService")
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {

    @Override
    public Page<Post> recommend(Integer pageNum, Integer pageSize, Long schoolId, Long partId) {
        LambdaQueryWrapper<Post> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Post::getSchoolId,schoolId);
        wrapper.eq(Post::getPartId,partId);
        Page<Post> page = new Page<>(pageNum,pageSize);
        page(page,wrapper);
        return page;
    }

    @Override
    public Page<Post> getPostByUserId(Integer pageNum, Integer pageSize, Long userId) {
        LambdaQueryWrapper<Post> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Post::getUserId,userId);
        Page<Post> page = new Page<>(pageNum,pageSize);
        page(page,wrapper);
        return page;
    }
}

