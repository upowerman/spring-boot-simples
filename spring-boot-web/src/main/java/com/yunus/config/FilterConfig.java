package com.yunus.config;

import com.yunus.filter.FilterFoo;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new FilterFoo());
        registration.addUrlPatterns("/*");
        registration.setEnabled(true);
        return registration;
    }
}
