package com.gbd.forum.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gbd.forum.entity.Post;
import com.gbd.forum.entity.User;
import com.gbd.forum.entity.dto.PostCardDto;
import com.gbd.forum.entity.dto.PostDto;
import com.gbd.forum.entity.dto.UserDto;
import com.gbd.forum.mapper.PostMapper;
import com.gbd.forum.service.PostService;
import com.gbd.forum.service.UsersService;
import com.gbd.forum.utils.BeanCopyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Post)表服务实现类
 *
 * @author makejava
 * @since 2023-04-09 23:32:38
 */
@Service("postService")
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {

    @Autowired
    private UsersService usersService;

    @Override
    public Page<PostCardDto> recommend(Integer pageNum, Integer pageSize, Long schoolId, Long partId) {
        LambdaQueryWrapper<Post> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Post::getSchoolId,schoolId);
        wrapper.eq(Post::getPartId,partId);
        wrapper.orderByDesc(Post::getCreateTime);
        Page<Post> page = new Page<>(pageNum,pageSize);
        page(page,wrapper);

        List<PostCardDto> postCardDtoList = new ArrayList<>();
        List<Post> records = page.getRecords();
        records.forEach(item->{
            PostCardDto postCardDto = BeanCopyUtils.copyBean(item, PostCardDto.class);
            User byId = usersService.getById(item.getUserId());
            UserDto userDto = BeanCopyUtils.copyBean(byId, UserDto.class);
            postCardDto.setUser(userDto);
            postCardDtoList.add(postCardDto);
        });

        Page<PostCardDto> newPage = new Page<>();
        BeanUtils.copyProperties(page,newPage);
        newPage.setRecords(postCardDtoList);
        return newPage;
    }

    @Override
    public Page<Post> getPostByUserId(Integer pageNum, Integer pageSize, Long userId) {
        LambdaQueryWrapper<Post> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Post::getUserId,userId);
        Page<Post> page = new Page<>(pageNum,pageSize);
        page(page,wrapper);
        return page;
    }

    @Override
    public Map<String,Object> getDetailById(Serializable id) {
        Post post = this.baseMapper.selectById(id);
        User user = usersService.getById(post.getUserId());
        UserDto userDto = BeanCopyUtils.copyBean(user, UserDto.class);
        PostDto postDto = BeanCopyUtils.copyBean(post, PostDto.class);
        Map<String,Object> map = new HashMap<>();
        map.put("post", postDto);
        map.put("user",userDto);

        //TODO 评论待添加


        return map;
    }
}

