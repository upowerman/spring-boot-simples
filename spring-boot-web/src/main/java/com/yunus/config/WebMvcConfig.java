package com.yunus.config;

import com.yunus.base.IntToGenderConverter;
import com.yunus.base.StringToDateConvertor;
import com.yunus.intercepter.IntercepterFoo;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new IntToGenderConverter());
        registry.addConverter(new StringToDateConvertor());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new IntercepterFoo()).addPathPatterns("/**");
    }


}
