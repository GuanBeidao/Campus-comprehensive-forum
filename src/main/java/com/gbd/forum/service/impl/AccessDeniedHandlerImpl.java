package com.gbd.forum.service.impl;

import com.alibaba.fastjson.JSON;
import com.gbd.forum.utils.ResponseResult;
import com.gbd.forum.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Date: 2023/4/27 8:39
 * Author: GuanBD
 * Description:
 */

@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {

        ResponseResult result = new ResponseResult(HttpStatus.FORBIDDEN.value(), "权限不足" , null);
        String json = JSON.toJSONString(result);
        WebUtils.renderString(response,json);

    }

}
