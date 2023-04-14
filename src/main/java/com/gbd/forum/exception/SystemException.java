package com.gbd.forum.exception;

import com.gbd.forum.enums.HttpCodeEnum;

/**
 * Date: 2023/2/19 22:00
 * Author: GuanBD
 * Description:
 */

public class SystemException extends RuntimeException{

    private int code;

    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public SystemException(HttpCodeEnum httpCodeEnum) {
        super(httpCodeEnum.getMsg());
        this.code = httpCodeEnum.getCode();
        this.msg = httpCodeEnum.getMsg();
    }

}
