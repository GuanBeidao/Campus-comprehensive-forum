package com.gbd.forum.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gbd.forum.entity.Reply;
import com.gbd.forum.entity.dto.ReplyDto;


/**
 * (Reply)表服务接口
 *
 * @author makejava
 * @since 2023-04-09 23:32:11
 */
public interface ReplyService extends IService<Reply> {

    Page<ReplyDto> getReply(Integer pageNum, Integer pageSize, Long postId);
}

