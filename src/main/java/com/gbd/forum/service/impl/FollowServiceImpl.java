package com.gbd.forum.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gbd.forum.entity.Follow;
import com.gbd.forum.entity.User;
import com.gbd.forum.mapper.FollowMapper;
import com.gbd.forum.service.FollowService;
import com.gbd.forum.service.UsersService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * (Follow)表服务实现类
 *
 * @author makejava
 * @since 2023-04-09 23:32:50
 */
@Service("followService")
public class FollowServiceImpl extends ServiceImpl<FollowMapper, Follow> implements FollowService {

    @Autowired
    private UsersService usersService;

    @Override
    public Page<User> pageFollower(Integer pageNum, Integer pageSize, Long followeeId) {
        LambdaQueryWrapper<Follow> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Follow::getFolloweeId,followeeId);
        Page<Follow> page = new Page<>(pageNum,pageSize);
        Page<Follow> followPage = this.page(page, wrapper);
        List<Follow> followList = followPage.getRecords();
        List<User> userList = new ArrayList<>();
        followList.forEach(item->{
            User user = usersService.getById(item.getFollowerId());
            user.setPassword("");
            userList.add(user);
        });
        Page<User> usersPage = new Page<>();
        BeanUtils.copyProperties(followPage,usersPage);
        usersPage.setRecords(userList);
        return usersPage;
    }

    @Override
    public Page<User> pageFollowee(Integer pageNum, Integer pageSize, Long followerId) {
        LambdaQueryWrapper<Follow> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Follow::getFollowerId,followerId);
        Page<Follow> page = new Page<>(pageNum,pageSize);
        Page<Follow> followPage = this.page(page, wrapper);
        List<Follow> followList = followPage.getRecords();
        List<User> userList = new ArrayList<>();
        followList.forEach(item->{
            User user = usersService.getById(item.getFolloweeId());
            user.setPassword("");
            userList.add(user);
        });
        Page<User> usersPage = new Page<>();
        BeanUtils.copyProperties(followPage,usersPage);
        usersPage.setRecords(userList);
        return usersPage;
    }
}

