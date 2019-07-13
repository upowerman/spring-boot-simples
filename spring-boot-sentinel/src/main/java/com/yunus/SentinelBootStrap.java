package com.yunus;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class SentinelBootStrap {

    public static void main(String[] args) {
        SpringApplication.run(SentinelBootStrap.class, args);
    }

    @Slf4j
    @RestController
    static class TestController {

        @GetMapping("/hello")
        public Object hello() {
            Map<String,String> result = new HashMap<>();
            result.put("hello","world");
            return result;
        }

    }

}
