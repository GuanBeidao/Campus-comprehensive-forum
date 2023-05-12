package com.gbd.forum.enums;

/**
 * Date: 2023/2/18 19:58
 * Author: GuanBD
 * Description:
 */

public enum HttpCodeEnum {

    // 成功
    SUCCESS(200,"操作成功"),
    // 登录 201-210
    LOGIN_SUCCESS(2001,"登录成功"),

    //文章
    ADD_POST_SUCCESS(2021,"发布文章成功"),

    ADD_POST_FAIL(5011,"发布文章失败"),

    // 关注  ==============================================================================
    ADD_FOLLOW_SUCCESS(2041,"关注成功"),
    REMOVE_FOLLOW_SUCCESS(2042,"取消关注成功"),
    FIND_FOLLOW_YES(2043,"已关注"),
    FIND_FOLLOW_NO(2044,"未关注"),

    ADD_FOLLOW_FAIL(5041,"关注失败"),
    REMOVE_FOLLOW_FAIL(5042,"取消关注失败"),

    // 评论 =================================================================================
    ADD_REPLY_SUCCESS(2061,"添加评论成功"),
    GET_REPLY_SUCCESS(2062,"加载评论成功"),

    ADD_REPLY_FAIL(5061,"添加评论失败"),
    GET_REPLY_FAIL(5062,"加载评论失败"),

    // =====================================================================================
    NEED_LOGIN(401,"需要登录后操作"),
    NO_OPERATOR_AUTH(403,"无权限操作"),


    SYSTEM_ERROR(500,"出现错误"),
    USERNAME_EXIST(5001,"用户名已存在"),
    PHONENUMBER_EXIST(5002,"手机号已存在"),
    EMAIL_EXIST(5003, "邮箱已存在"),
    REQUIRE_USERNAME(5004, "必需填写用户名"),
    LOGIN_ERROR(5005,"用户名或密码错误"),
    CONTENT_NOT_NULL(5006, "评论不能为空"),
    FILE_TYPE_ERROR(5007, "图片不能为空"),
    REGISTER_FAIL_ACCOUNT(5008, "账号已存在"),
    REGISTER_FAIL_NICKNAME(5009, "昵称重复"),
    REGISTER_FAIL_EMAIL(5010, "邮箱已注册"),
    USERNAME_NOT_NULL(5011, "用户名不能为空"),
    NICKNAME_NOT_NULL(5012, "昵称不能为空"),
    PASSWORD_NOT_NULL(5013, "密码不能为空"),
    EMAIL_NOT_NULL(5014, "邮箱不能为空");


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
