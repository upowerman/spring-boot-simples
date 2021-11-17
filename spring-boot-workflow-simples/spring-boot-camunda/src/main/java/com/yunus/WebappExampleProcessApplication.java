package com.yunus;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author gaoyunfeng
 */
@SpringBootApplication
@EnableProcessApplication
public class WebappExampleProcessApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebappExampleProcessApplication.class, args);
    }
}
