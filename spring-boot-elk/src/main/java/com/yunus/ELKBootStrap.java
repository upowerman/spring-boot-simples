package com.yunus;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class ELKBootStrap {

    Logger logger = LoggerFactory.getLogger(ELKBootStrap.class);

    public static void main(String[] args) {
        SpringApplication.run(ELKBootStrap.class, args);
    }

    @PostConstruct
    public void testLogstash() throws InterruptedException {
        while (true){
            TimeUnit.SECONDS.sleep(1);
            logger.info("this is a test logstash 测试");
        }
    }
}
