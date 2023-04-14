package com.gbd.forum.enums;

/**
 * Date: 2023/2/18 19:58
 * Author: GuanBD
 * Description:
 */

public enum HttpCodeEnum {

    // 成功
    SUCCESS(200,"操作成功"),
    // 登录
    NEED_LOGIN(401,"需要登录后操作"),
    NO_OPERATOR_AUTH(403,"无权限操作"),
    SYSTEM_ERROR(500,"出现错误"),
    USERNAME_EXIST(501,"用户名已存在"),
    PHONENUMBER_EXIST(502,"手机号已存在"),
    EMAIL_EXIST(503, "邮箱已存在"),
    REQUIRE_USERNAME(504, "必需填写用户名"),
    LOGIN_ERROR(505,"用户名或密码错误"),
    CONTENT_NOT_NULL(506, "评论不能为空"),
    FILE_TYPE_ERROR(507, "图片不能为空"),
    REGISTER_FAIL_ACCOUNT(508, "账号已存在"),
    REGISTER_FAIL_NICKNAME(509, "昵称重复"),
    REGISTER_FAIL_EMAIL(510, "邮箱已注册"),
    USERNAME_NOT_NULL(511, "用户名不能为空"),
    NICKNAME_NOT_NULL(512, "昵称不能为空"),
    PASSWORD_NOT_NULL(513, "密码不能为空"),
    EMAIL_NOT_NULL(514, "邮箱不能为空");
    int code;
    String msg;

    HttpCodeEnum(int code, String errorMessage){
        this.code = code;
        this.msg = errorMessage;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
