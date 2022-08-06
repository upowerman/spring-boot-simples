package com.yunus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author gaoyunfeng
 */
@SpringBootApplication
@MapperScan("com.yunus.mapper")
public class BootStrapServer {
    public static void main(String[] args) {
        SpringApplication.run(BootStrapServer.class, args);
    }
}
