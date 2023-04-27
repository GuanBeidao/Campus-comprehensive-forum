package com.gbd.forum.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gbd.forum.entity.Follow;
import com.gbd.forum.entity.User;
import com.gbd.forum.service.FollowService;
import com.gbd.forum.utils.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Follow)表控制层
 *
 * @author makejava
 * @since 2023-04-09 23:32:50
 */
@RestController
@RequestMapping("follow")
public class FollowController {
    /**
     * 服务对象
     */
    @Resource
    private FollowService followService;

    /**
     * 分页查询粉丝
     *
     * @param pageNum 当前页数
     * @param pageSize 每页数据大小
     * @param followeeId 被关注者id
     * @return 所有数据
     */
    @GetMapping("/findFollower")
    public ResponseResult selectAllFollower(Integer pageNum, Integer pageSize, Long followeeId) {
        Page<User> usersPage = followService.pageFollower(pageNum, pageSize, followeeId);
        return ResponseResult.okResult(usersPage);
    }

    /**
     * 分页查询关注
     *
     * @param pageNum 当前页数
     * @param pageSize 每页数据大小
     * @return 所有数据
     */
    @GetMapping("/findFollowee")
    public ResponseResult selectAllFolowwee(Integer pageNum, Integer pageSize, Long followerId) {
        Page<User> usersPage = followService.pageFollowee(pageNum, pageSize, followerId);
        return ResponseResult.okResult(usersPage);
    }

    /**
     * 新增数据
     *
     * @param follow 实体对象
     * @return 新增结果
     */
    @PostMapping
    public ResponseResult insert(@RequestBody Follow follow) {
        boolean save = followService.save(follow);
        if (save){
            return ResponseResult.okResult();
        }else{
            return ResponseResult.errorResult(201,"添加失败");
        }
    }

    /**
     * 取消关注
     *
     * @param myselfId 本人id
     * @param yourselfId 对方id
     * @return 删除结果
     */
    @DeleteMapping("removeFollower/{myselfId}/{yourselfId}")
    public ResponseResult removeFollower(@PathVariable Long myselfId,@PathVariable Long yourselfId) {
        LambdaQueryWrapper<Follow> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Follow::getFollowerId,myselfId);
        wrapper.eq(Follow::getFolloweeId,yourselfId);
        followService.remove(wrapper);
        return ResponseResult.okResult();
    }

    /**
     * 移除粉丝
     *
     * @param myselfId 本人id
     * @param yourselfId 对方id
     * @return 删除结果
     */
    @DeleteMapping("removeFollowee/{myselfId}/{yourselfId}")
    public ResponseResult removeFollowee(@PathVariable Long myselfId,@PathVariable Long yourselfId) {
        LambdaQueryWrapper<Follow> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Follow::getFollowerId,yourselfId);
        wrapper.eq(Follow::getFolloweeId,myselfId);
        followService.remove(wrapper);
        return ResponseResult.okResult();
    }
}

