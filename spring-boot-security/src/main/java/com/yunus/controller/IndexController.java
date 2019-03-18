package com.yunus.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: gaoyunfeng
 * @date: 2019/3/18
 */
@RestController
public class IndexController {

    @GetMapping("/index")
    public Object index() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
