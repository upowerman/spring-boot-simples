package com.yunus.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * @author M4500
 * @see http://www.iocoder.cn/Spring-Boot/Spring-Security/?self
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // 配置请求地址的权限 调用HttpSecurity#authorizeRequests()
                .authorizeRequests()
                    // 所有用户可访问
                    .antMatchers("/test/demo").permitAll()
                    // 需要 ADMIN 角色
                    .antMatchers("/test/admin").hasRole("ADMIN")
                    // 需要 NORMAL 角色。
                    .antMatchers("/test/normal").access("hasRole('ROLE_NORMAL')")
                    // 任何请求，访问的用户都需要经过认证 登录用户可访问。
                    .anyRequest().authenticated()
                .and()
                // 设置 Form 表单登陆
                .formLogin()
                // 登陆 URL 地址
                    //.loginPage("/login")
                    .permitAll() // 所有用户可访问
                .and()
                // 配置退出相关
                .logout()
                // 退出 URL 地址
                    //.logoutUrl("/logout")
                    // 所有用户可访问
                    .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                // <X> 使用内存中的 InMemoryUserDetailsManager
                .inMemoryAuthentication()
                // <Y> 不使用 PasswordEncoder 密码编码器 调用 AbstractDaoAuthenticationConfigurer#passwordEncoder(passwordEncoder)
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                // <Z> 配置 admin 用户
                .withUser("admin").password("admin").roles("ADMIN")
                .and()
                // <Z> 配置 admin 用户
                .withUser("normal").password("normal").roles("NORMAL");
    }

}
