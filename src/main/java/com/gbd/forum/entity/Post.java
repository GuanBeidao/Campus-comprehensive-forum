package com.gbd.forum.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * (Post)表实体类
 *
 * @author makejava
 * @since 2023-04-09 23:32:38
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("post")
public class Post  {
    //帖子id@TableId
    @TableId(type = IdType.AUTO)
    private Long id;

    //标题
    private String title;
    //内容
    private String content;
    //用户id
    private Long userId;
    //学校id
    private Long schoolId;
    //学校id
    private Long partId;
    //逻辑删除（0未删除，1已删除）
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer isDelete;
    //创建时间
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    //更新时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;



}

