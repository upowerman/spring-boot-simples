package com.yunus.config;

import com.yunus.handler.MyAuthenticationFailureHandler;
import com.yunus.handler.MyAuthenticationSuccessHandler;
import com.yunus.validate.smscode.SmsAuthenticationConfig;
import com.yunus.validate.smscode.SmsCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author gaoyunfeng
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private MyAuthenticationSuccessHandler authenticationSuccessHandler;
    @Autowired
    private MyAuthenticationFailureHandler authenticationFailureHandler;
    @Autowired
    private SmsCodeFilter smsCodeFilter;
    @Autowired
    private SmsAuthenticationConfig smsAuthenticationConfig;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(smsCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin() // 表单登录
                .loginProcessingUrl("/login")
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
                .and()
                .authorizeRequests() // 授权配置
                .antMatchers("/code/sms").permitAll()
                .anyRequest()  // 所有请求
                .authenticated() // 都需要认证
                .and()
                .csrf().disable()
                .apply(smsAuthenticationConfig);
    }
}