package com.yunus.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @Author: gaoyunfeng
 * @date: 2019/4/3
 */
public class SpringLifeCycleService implements InitializingBean, DisposableBean {
    private final static Logger LOGGER = LoggerFactory.getLogger(SpringLifeCycleService.class);

    @Override
    public void afterPropertiesSet() throws Exception {
        LOGGER.info("SpringLifeCycleService start");
    }

    @Override
    public void destroy() throws Exception {
        LOGGER.info("SpringLifeCycleService destroy");
    }
}
