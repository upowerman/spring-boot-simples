package com.yunus.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: gaoyunfeng
 * @date: 2019/3/14
 */
@RestController
@RequestMapping
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }
}
