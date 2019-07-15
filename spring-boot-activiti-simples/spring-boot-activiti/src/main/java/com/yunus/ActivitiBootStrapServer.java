package com.yunus;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.yunus.mapper")
@EnableScheduling
public class ActivitiBootStrapServer {

    public static void main(String[] args) {
        SpringApplication.run(ActivitiBootStrapServer.class, args);
    }

}
