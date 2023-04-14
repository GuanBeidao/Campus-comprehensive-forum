package com.gbd.forum.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Date: 2023/4/10 23:07
 * Author: GuanBD
 * Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginVo {

    //账号
    private String username;
    //密码
    private String password;

}
