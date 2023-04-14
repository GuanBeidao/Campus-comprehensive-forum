package com.gbd.forum.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * (Follow)表实体类
 *
 * @author makejava
 * @since 2023-04-09 23:32:50
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("follow")
public class Follow  {
    //关注id@TableId
    @TableId(type = IdType.AUTO)
    private Long id;

    //粉丝id
    private Long followerId;
    //被关注者id
    private Long followeeId;
    //创建时间
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

}

