package com.gbd.forum.config;

import com.gbd.forum.filter.JwtAuthenticationTokenFilter;
import com.gbd.forum.service.impl.AccessDeniedHandlerImpl;
import com.gbd.forum.service.impl.AuthenticationEntryPointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Date: 2023/4/18 18:06
 * Author: GuanBD
 * Description:
 */

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Autowired
    private AuthenticationEntryPointImpl authenticationEntryPoint;

    @Autowired
    private AccessDeniedHandlerImpl accessDeniedHandler;

    @Autowired
    private UserDetailsService userDetailService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(password());
    }

    // 配置Spring Security的拦截规则
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()                                                               // 关闭csrf
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)     // 指定session的创建策略，不使用session
                .and()                                                                          // 再次获取到HttpSecurity对象
                .authorizeRequests()                                                            // 进行认证请求的配置
                .antMatchers("/user/login", "/user/register",
                        "/partition", "/schools/getAllSchool",
                        "/post/recommend/{pageNum}/{pageSize}/{schoolId}/{partId}",
                        "/post/getDetail/{id}",
                        "/reply/getReply/{pageNum}/{pageSize}/{postId}"
                ).permitAll()                              // 对于登录接口，允许匿名访问
                .anyRequest().authenticated();                                                  // 除了上面的请求以外所有的请求全部需要认证

        http.cors();    //允许资源跨域

        //将jwt认证失败处理器添加到springsecurity的过滤器链中
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        //添加认证失败处理器和权限校验失败处理器
        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler).authenticationEntryPoint(authenticationEntryPoint);

    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    PasswordEncoder password() {
        return new BCryptPasswordEncoder();
    }
}
