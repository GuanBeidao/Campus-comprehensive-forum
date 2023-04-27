package com.gbd.forum.service.impl;

import com.alibaba.fastjson.JSON;
import com.gbd.forum.utils.ResponseResult;
import com.gbd.forum.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Date: 2023/4/27 8:38
 * Author: GuanBD
 * Description:
 */

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ResponseResult result = new ResponseResult(HttpStatus.UNAUTHORIZED.value(), "认证失败请重新登录", null);
        String json = JSON.toJSONString(result) ;
        WebUtils.renderString(response,json);
    }

}
