package com.yunus.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2021/2/5 17:53
 */
@RestController
@RequestMapping("/demo")
public class DemoController {


    @GetMapping("/echo")
    public String echo(String echo) {
        return echo;
    }

    @GetMapping("/hello")
    @PreAuthorize("@RBAC.hasRole('common')")
    public String hello(String name) {
        return "hello" + name;
    }

    @GetMapping("/hi")
    @PreAuthorize("@RBAC.hasPermission('system')")
    public String hi(String name) {
        return "hi" + name;
    }
}
