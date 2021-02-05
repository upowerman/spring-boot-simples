package com.yunus.security;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author gaoyunfeng
 * @Description: token认证过滤器
 * @date 2021/2/5 13:35
 */
@Component
public class JwtAuthenticationTokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }
}
