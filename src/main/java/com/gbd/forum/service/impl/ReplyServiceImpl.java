package com.gbd.forum.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gbd.forum.entity.Reply;
import com.gbd.forum.entity.dto.ReplyDto;
import com.gbd.forum.mapper.ReplyMapper;
import com.gbd.forum.service.ReplyService;
import com.gbd.forum.utils.BeanCopyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Reply)表服务实现类
 *
 * @author makejava
 * @since 2023-04-09 23:32:11
 */
@Service("replyService")
public class ReplyServiceImpl extends ServiceImpl<ReplyMapper, Reply> implements ReplyService {

    @Override
    public Page<ReplyDto> getReply(Integer pageNum, Integer pageSize, Long postId) {
        Page<Reply> replyPage = new Page<>(pageNum,pageSize);
        LambdaQueryWrapper<Reply> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Reply::getPostId,postId);
        wrapper.eq(Reply::getReplyId,-1);
        page(replyPage, wrapper);

        List<ReplyDto> replyDtos = BeanCopyUtils.copyBeanList(replyPage.getRecords(), ReplyDto.class);

        replyDtos.forEach(item->{
            List<ReplyDto> childrenReply = findChildrenReply(postId,item.getId());
            item.setChildren(childrenReply);
        });

        Page<ReplyDto> dtoPage = new Page<>();
        BeanUtils.copyProperties(replyPage,dtoPage);

        dtoPage.setRecords(replyDtos);

        return dtoPage;
    }

    public List<ReplyDto> findChildrenReply(Long postId,Long id){
        LambdaQueryWrapper<Reply> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Reply::getReplyId,id);
        wrapper.eq(Reply::getPostId,postId);
        List<Reply> list = list(wrapper);
        List<ReplyDto> replyDtos = BeanCopyUtils.copyBeanList(list, ReplyDto.class);
        replyDtos.forEach(item->{
            List<ReplyDto> childrenReply = findChildrenReply(postId,item.getId());
            item.setChildren(childrenReply);
        });
        return replyDtos;
    }
}

