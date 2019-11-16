package com.yunus.config;

import com.yunus.plugin.PagingPlugin;
import org.apache.ibatis.plugin.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author gaoyunfeng
 */
@Configuration
public class Config {
    @Bean
    public Interceptor pagingPlugin(){
        return new PagingPlugin();
    }
}
