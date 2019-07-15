package com.yunus.helloworld;

import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * activiti 配置测试类ß
 */
public class ConfigTest {

    Logger logger = LoggerFactory.getLogger(ConfigTest.class);

    @Test
    public void configTest1() {
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault();
        logger.info("configuration = {}", configuration);
    }

    @Test
    public void configTest2() {
        ProcessEngineConfiguration cfg = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
        logger.info("configuration = {}", cfg);
    }
}
