package com.gbd.forum.entity.dto;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * Date: 2023/5/12 12:42
 * Author: GuanBD
 * Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyDto {
    //评论id@TableId
    private Long id;
    //帖子id
    private Long postId;
    //回复内容
    private String content;
    //被回复id（-1表示顶级回复）
    private Long replyId;
    //回复者id
    private Long userId;
    //被回复者id
    private Long userIdReplied;
    //创建时间
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(exist = false)
    private List<ReplyDto> children;

}
