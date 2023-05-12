package com.gbd.forum.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * (Reply)表实体类
 *
 * @author makejava
 * @since 2023-04-09 23:32:11
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("reply")
public class Reply  {
    //回复id@TableId
    @TableId(type = IdType.AUTO)
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
    //逻辑删除（0未删除，1已删除）
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer isDelete;
    //创建时间
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

}

