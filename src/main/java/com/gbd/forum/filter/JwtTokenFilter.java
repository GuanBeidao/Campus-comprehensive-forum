package com.gbd.forum.filter;

import com.gbd.forum.enums.HttpCodeEnum;
import com.gbd.forum.exception.SystemException;
import com.gbd.forum.utils.JwtUtil;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * Date: 2023/4/12 15:02
 * Author: GuanBD
 * Description:
 */

@Component
@WebFilter(filterName = "JwtTokenFilter", urlPatterns = "/*")
public class JwtTokenFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @SneakyThrows
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /*HttpServletRequest request = (HttpServletRequest) servletRequest;
        if (request.getRequestURI().contains("/users/login") || request.getRequestURI().contains("/users/register")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            String token = request.getHeader("token");
            if (!JwtUtil.checkToken(token)) {
                throw new SystemException(HttpCodeEnum.NEED_LOGIN);
            }
            filterChain.doFilter(servletRequest, servletResponse);
        }*/
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
