package com.yunus.helloworld;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigDbTest {

    Logger logger = LoggerFactory.getLogger(ConfigDbTest.class);


    @Test
    public void test1() {
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault();
        logger.info("创建流程配置 【{}】", configuration);
        ProcessEngine processEngine = configuration.buildProcessEngine();
        logger.info("获取流程引擎 「{}」", processEngine);
        processEngine.close();
    }

}
