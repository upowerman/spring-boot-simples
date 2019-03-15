package com.yunus.controller;

import com.yunus.service.UserService;
import com.yunus.service.UserService1;
import com.yunus.service.UserService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: gaoyunfeng
 * @date: 2019/3/15
 */
@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserService1 userService1;
    @Autowired
    private UserService2 userService2;

    @GetMapping("/test1")
    public void test1(@RequestParam("id") Long id) {
        userService.test3(id);
    }
}
