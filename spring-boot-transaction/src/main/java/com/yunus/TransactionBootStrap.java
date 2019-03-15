package com.yunus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: gaoyunfeng
 * @date: 2019/3/15
 */
@SpringBootApplication
@MapperScan("com.yunus.dao")
public class TransactionBootStrap {
    public static void main(String[] args) {
        SpringApplication.run(TransactionBootStrap.class, args);
    }
}
