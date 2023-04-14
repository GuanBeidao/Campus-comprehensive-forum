package com.gbd.forum.controller;



import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gbd.forum.entity.Post;
import com.gbd.forum.service.PostService;
import com.gbd.forum.utils.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Post)表控制层
 *
 * @author makejava
 * @since 2023-04-09 23:32:38
 */
@RestController
@RequestMapping("post")
public class PostController {
    /**
     * 服务对象
     */
    @Resource
    private PostService postService;

    /**
     * 分页查询所有数据
     *
     * @param pageNum 当前页数
     * @param pageSize 每页数据大小
     * @return 所有数据
     */
    @GetMapping("/recommend/{pageNum}/{pageSize}/{schoolId}/{partId}")
    public ResponseResult selectAll(@PathVariable Integer pageNum,@PathVariable Integer pageSize,@PathVariable Long schoolId,@PathVariable Long partId) {
        Page<Post> postPage = postService.recommend(pageNum,pageSize,schoolId,partId);
        return ResponseResult.okResult(postPage);
    }

    /**
     * 分页查询所有者的帖子
     *
     * @param pageNum 当前页数
     * @param pageSize 每页数据大小
     * @return 所有数据
     */
    @GetMapping("/getPostByUserId/{pageNum}/{pageSize}/{userId}")
    public ResponseResult owner(@PathVariable Integer pageNum,@PathVariable Integer pageSize,@PathVariable Long userId) {
        Page<Post> postPage = postService.getPostByUserId(pageNum,pageSize,userId);
        return ResponseResult.okResult(postPage);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseResult selectOne(@PathVariable Serializable id) {
        Post post = postService.getById(id);
        return ResponseResult.okResult(post);
    }

    /**
     * 新增数据
     *
     * @param post 实体对象
     * @return 新增结果
     */
    @PostMapping("/addPost")
    public ResponseResult insert(@RequestBody Post post) {
        boolean save = postService.save(post);
        return ResponseResult.okResult();
    }

    /**
     * 修改数据
     *
     * @param post 实体对象
     * @return 修改结果
     */
    @PutMapping("/updatePost")
    public ResponseResult update(@RequestBody Post post) {
        postService.updateById(post);
        return ResponseResult.okResult();
    }

    /**
     * 删除数据
     *
     * @param postId 帖子id
     * @return 删除结果
     */
    @DeleteMapping("/removePost/{postId}")
    public ResponseResult delete(@PathVariable Long postId) {
        postService.removeById(postId);
        return ResponseResult.okResult();
    }
}

