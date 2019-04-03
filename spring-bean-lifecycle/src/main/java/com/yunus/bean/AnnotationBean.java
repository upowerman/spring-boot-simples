package com.yunus.bean;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author: gaoyunfeng
 * @date: 2019/4/3
 */
@Slf4j
public class AnnotationBean {

    @PostConstruct
    public void start() {
        log.info("class AnnotationBean @postConstruct start() 方法执行");
    }

    @PreDestroy
    public void destroy() {
        log.info("class AnnotationBean @PreDestroy destroy() 方法执行");
    }
}
