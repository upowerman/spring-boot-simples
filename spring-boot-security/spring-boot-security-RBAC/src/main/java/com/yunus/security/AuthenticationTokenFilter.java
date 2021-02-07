package com.yunus.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gaoyunfeng
 * @Description:
 * @see org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
 * @date 2021/2/5 18:03
 */
@Component
public class AuthenticationTokenFilter extends OncePerRequestFilter {

    private final TokenService tokenService;

    public AuthenticationTokenFilter(final TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String token = tokenService.getToken(request);
        if (!StringUtils.isEmpty(token) && SecurityContextHolder.getContext().getAuthentication() == null) {
            tokenService.verifyToken(token);
            UserDetails userDetails = tokenService.getUserDetailByToken(token);
            // 设置
            if (userDetails != null) {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        chain.doFilter(request, response);
    }
}
