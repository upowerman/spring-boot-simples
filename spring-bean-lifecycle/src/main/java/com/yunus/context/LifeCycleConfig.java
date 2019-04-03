package com.yunus.context;

import com.yunus.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: gaoyunfeng
 * @date: 2019/4/3
 */
@Configuration
public class LifeCycleConfig {


    @Bean(initMethod = "start", destroyMethod = "destroy")
    public SpringLifeCycle create() {
        SpringLifeCycle springLifeCycle = new SpringLifeCycle();
        return springLifeCycle;
    }

    @Bean
    public AnnotationBean annotationBean() {
        return new AnnotationBean();
    }

    @Bean
    public SpringLifeCycleAware springLifeCycleAware() {
        return new SpringLifeCycleAware();
    }

    @Bean
    public SpringLifeCycleProcessor springLifeCycleProcessor() {
        return new SpringLifeCycleProcessor();
    }

    @Bean
    public SpringLifeCycleService springLifeCycleService() {
        return new SpringLifeCycleService();
    }
}

