package com.yunus.config.auth;

import com.alibaba.fastjson.JSON;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义登录成功逻辑
 *
 * @Author: gaoyunfeng
 * @date: 2019/3/15
 */
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // 返回 授权后信息
        //response.setContentType("application/json;charset=utf-8");
        //response.getWriter().write(JSON.toJSONString(authentication));
        // 跳转
        redirectStrategy.sendRedirect(request, response, "/index");
    }
}
