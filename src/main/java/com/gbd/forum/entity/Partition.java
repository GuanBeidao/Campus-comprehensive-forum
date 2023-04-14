package com.gbd.forum.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (Partition)表实体类
 *
 * @author makejava
 * @since 2023-04-12 22:29:36
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("partitions")
public class Partition  {
    //板块id@TableId
    @TableId(type = IdType.AUTO)
    private Long id;

    //板块名称
    private String partName;
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

