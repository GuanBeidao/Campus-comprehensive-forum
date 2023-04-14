package com.gbd.forum.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * (StudentIdentity)表实体类
 *
 * @author makejava
 * @since 2023-04-09 23:31:32
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("student_identity")
public class StudentIdentity  {
    //认证id@TableId
    @TableId(type = IdType.AUTO)
    private Long id;

    //学校id
    private Long schoolId;
    //用户id
    private Long userId;
    //学生证图片
    private String cardUrl;
    //创建时间
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;



}

