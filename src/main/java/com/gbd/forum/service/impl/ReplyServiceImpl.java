package com.gbd.forum.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gbd.forum.entity.Reply;
import com.gbd.forum.mapper.ReplyMapper;
import com.gbd.forum.service.ReplyService;
import org.springframework.stereotype.Service;

/**
 * (Reply)表服务实现类
 *
 * @author makejava
 * @since 2023-04-09 23:32:11
 */
@Service("replyService")
public class ReplyServiceImpl extends ServiceImpl<ReplyMapper, Reply> implements ReplyService {

}

