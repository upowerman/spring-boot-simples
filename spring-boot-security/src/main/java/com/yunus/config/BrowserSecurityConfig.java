package com.yunus.config;

import com.yunus.config.auth.CustomAuthenticationFailureHandler;
import com.yunus.config.auth.CustomAuthenticationSuccessHandler;
import com.yunus.config.auth.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Author: gaoyunfeng
 * @date: 2019/3/15
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private ValidateCodeFilter validateCodeFilter;


    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new CustomAuthenticationSuccessHandler();
    }

    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new CustomAuthenticationFailureHandler();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 添加验证码校验过滤器
        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin() // 表单登录
                // http.httpBasic() // HTTP Basic
                // 登录跳转 URL
                .loginPage("/statics/login.html")
                // 处理表单登录 URL
                .loginProcessingUrl("/login")
                // 处理登录成功
                .successHandler(authenticationSuccessHandler())
                // 处理登录失败
                .failureHandler(authenticationFailureHandler())
                .and()
                // 授权配置
                .authorizeRequests()
                // 登录跳转 URL 无需认证
                .antMatchers("/statics/**", "/code/image").permitAll()
                // 所有请求
                .anyRequest()
                // 都需要认证
                .authenticated()
                .and().csrf().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
