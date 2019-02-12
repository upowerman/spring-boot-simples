package com.yunus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author: gaoyunfeng
 * @date: 2019/2/12
 */
@SpringBootApplication
@EnableTransactionManagement
public class JpaServerBootStrap {
    public static void main(String[] args) {
        SpringApplication.run(JpaServerBootStrap.class, args);
    }
}
