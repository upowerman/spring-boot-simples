package com.yunus.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 示例模块 Controller
 * @author M4500
 */
@RestController
@RequestMapping("/api/example")
public class ExampleController {

    @RequestMapping("/hello")
    public String hello() {
        return "world";
    }

}
