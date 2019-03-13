package com.yunus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author: gaoyunfeng
 * @date: 2019/3/13
 */
@SpringBootApplication
@EnableScheduling
public class SocketBootStrapServer {
    public static void main(String[] args) {
        SpringApplication.run(SocketBootStrapServer.class, args);
    }
}
