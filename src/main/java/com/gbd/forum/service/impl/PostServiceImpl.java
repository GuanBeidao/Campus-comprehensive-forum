package com.gbd.forum.service.impl;

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

}

