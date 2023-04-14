package com.gbd.forum.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Date: 2023/4/10 0:16
 * Author: GuanBD
 * Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterVo {

    //用户昵称
    private String username;
    //账号
    private String account;
    //密码
    private String password;

}
