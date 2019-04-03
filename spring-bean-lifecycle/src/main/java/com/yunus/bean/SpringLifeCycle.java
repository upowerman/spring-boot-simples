package com.yunus.bean;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: gaoyunfeng
 * @date: 2019/4/3
 */
@Slf4j
public class SpringLifeCycle {

    public void start() {
        log.info("class SpringLifeCycle start() 方法执行");
    }


    public void destroy() {
        log.info("class SpringLifeCycle destroy() 方法执行");
    }
}

