package com.gbd.forum.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * (Users)表实体类
 *
 * @author makejava
 * @since 2023-04-09 23:12:17
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_user")
public class User {
    //用户id@TableId
    @TableId(type = IdType.AUTO)
    private Long id;

    //用户昵称
    private String nickname;
    //账号
    private String username;
    //密码
    private String password;
    //手机号
    private String phone;
    //邮箱
    private String email;
    //头像
    private String avatar;
    //性别（1男，2女）
    private Integer gender;
    //年龄
    private Integer age;
    //是否实名认证（0未认证，1已认证）
    private Integer isRealName;
    //是否学生认证（0未认证，1已认证）
    private Integer isStudent;
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

