package com.gbd.forum.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * (RealNameAuthentication)表实体类
 *
 * @author makejava
 * @since 2023-04-09 23:32:28
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("real_name_authentication")
public class RealNameAuthentication  {
    //认证id@TableId
    @TableId(type = IdType.AUTO)
    private Long id;

    //姓名
    private String realName;
    //身份证号
    private String idNumber;
    //用户id
    private Long userId;
    //创建时间
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;



}

