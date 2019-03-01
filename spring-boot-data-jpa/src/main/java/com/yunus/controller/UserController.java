package com.yunus.controller;

import com.yunus.transaction.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: gaoyunfeng
 * @date: 2019/2/27
 */
@RestController
@RequestMapping("/transaction")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String transaction() {
        userService.transactionTest1();
        return "ok";
    }
}
