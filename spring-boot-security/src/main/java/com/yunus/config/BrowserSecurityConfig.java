package com.yunus.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author: gaoyunfeng
 * @date: 2019/3/15
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 表单方式认证
        http.formLogin()
                .and()
                // 授权配置
                .authorizeRequests()
                // 所有请求
                .anyRequest()
                // 都需要认证
                .authenticated();
    }
}
