package com.yunus.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
public class UserController {


    /**
     * mono 声明 非阻塞
     *
     * @return
     */
    @GetMapping("/hello")
    public Mono<Object> hello() {
        Map<String, Object> result = new HashMap<>();
        result.put("hello", "world");
        return Mono.just(result);
    }


    @GetMapping("/world")
    public Object world() {
        Map map = Collections.singletonMap("key","value");
        return map;
    }

}
