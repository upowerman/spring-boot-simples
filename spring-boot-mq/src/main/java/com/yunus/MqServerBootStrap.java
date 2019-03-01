package com.yunus;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: gaoyunfeng
 * @date: 2019/3/1
 */
@EnableRabbit
@SpringBootApplication
public class MqServerBootStrap {

    public static void main(String[] args) {
        SpringApplication.run(MqServerBootStrap.class);
    }
}
