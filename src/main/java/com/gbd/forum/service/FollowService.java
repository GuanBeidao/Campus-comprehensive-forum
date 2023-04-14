package com.gbd.forum.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gbd.forum.entity.Follow;
import com.gbd.forum.entity.Users;


/**
 * (Follow)表服务接口
 *
 * @author makejava
 * @since 2023-04-09 23:32:50
 */
public interface FollowService extends IService<Follow> {

    Page<Users> pageFollower(Integer pageNum, Integer pageSize, Long followeeId);

    Page<Users> pageFollowee(Integer pageNum, Integer pageSize, Long followerId);
}

