package com.gbd.forum.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Date: 2023/4/18 16:16
 * Author: GuanBD
 * Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    //用户id@TableId
    private Long id;
    //用户昵称
    private String nickname;
    //账号
    private String username;
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

}
