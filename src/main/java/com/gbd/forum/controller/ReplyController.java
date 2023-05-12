package com.gbd.forum.controller;



import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gbd.forum.entity.Reply;
import com.gbd.forum.entity.dto.PostCardDto;
import com.gbd.forum.entity.dto.ReplyDto;
import com.gbd.forum.enums.HttpCodeEnum;
import com.gbd.forum.service.ReplyService;
import com.gbd.forum.utils.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Reply)表控制层
 *
 * @author makejava
 * @since 2023-04-09 23:32:11
 */
@RestController
@RequestMapping("reply")
public class ReplyController {
    /**
     * 服务对象
     */
    @Resource
    private ReplyService replyService;

    /**
     * 分页查询所有评论
     *
     * @param pageNum 当前页数
     * @param pageSize 每页数据大小
     * @return 所有数据
     */
    @GetMapping("/getReply/{pageNum}/{pageSize}/{postId}")
    public ResponseResult selectAll(@PathVariable Integer pageNum,@PathVariable Integer pageSize,@PathVariable Long postId) {
        Page<ReplyDto> replyPage = replyService.getReply(pageNum,pageSize,postId);
        return ResponseResult.okResult(HttpCodeEnum.GET_REPLY_SUCCESS,replyPage);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseResult selectOne(@PathVariable Serializable id) {
        return null;
    }

    /**
     * 新增数据
     *
     * @param reply 实体对象
     * @return 新增结果
     */
    @PostMapping("/addReply")
    public ResponseResult insert(@RequestBody Reply reply) {
        boolean save = replyService.save(reply);
        if (save){
            return ResponseResult.okResult(HttpCodeEnum.ADD_REPLY_SUCCESS);
        }else{
            return ResponseResult.okResult(HttpCodeEnum.ADD_REPLY_FAIL);
        }
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public ResponseResult delete(@RequestParam("idList") List<Long> idList) {
        return null;
    }
}

