package com.yunus.config;

import com.yunus.code.ValidateCodeFilter;
import com.yunus.code.smscode.SmsAuthenticationConfig;
import com.yunus.code.smscode.SmsCodeFilter;
import com.yunus.handler.MyAuthenticationFailureHandler;
import com.yunus.handler.MyAuthenticationSucessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * 此种认证方式都是security 自己生成的不是我们自定义的
 *
 * @author gaoyunfeng
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private MyAuthenticationSucessHandler authenticationSucessHandler;

    @Autowired
    private MyAuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    private ValidateCodeFilter validateCodeFilter;

    @Autowired
    private SmsCodeFilter smsCodeFilter;

    @Autowired
    private SmsAuthenticationConfig smsAuthenticationConfig;

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 添加验证码校验过滤器
        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(smsCodeFilter,UsernamePasswordAuthenticationFilter.class)
                .formLogin() // 表单登录
                    .loginPage("/login.html")
                    .loginProcessingUrl("/login")
                    // 处理登录成功
                    .successHandler(authenticationSucessHandler)
                    // 处理登录失败
                    .failureHandler(authenticationFailureHandler)
                .and()
                    // 配置 token 持久化仓库
                    .rememberMe().tokenRepository(persistentTokenRepository())
                    // remember 过期时间，单为秒
                    .tokenValiditySeconds(3600)
                // 处理自动登录逻辑
                .and()
                    .userDetailsService(userDetailService)
                    .authorizeRequests() // 授权配置
                    .antMatchers("/login.html",
                            "/code/image",
                            "/css/*").permitAll()
                    .anyRequest()  // 所有请求
                    .authenticated() // 都需要认证
                .and()
                    .csrf().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        jdbcTokenRepository.setCreateTableOnStartup(false);
        return jdbcTokenRepository;
    }

}
