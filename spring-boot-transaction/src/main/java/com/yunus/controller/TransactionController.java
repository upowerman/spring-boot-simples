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
        userService.test1(id);
    }

    @GetMapping("/test2")
    public void test2(@RequestParam("id") Long id) {
        userService.test2(id);
    }

    @GetMapping("/test3")
    public void test3(@RequestParam("id") Long id) {
        userService.test3(id);
    }

    @GetMapping("/test4")
    public void test4(@RequestParam("id") Long id) {
        userService1.methodC(id);
    }

    @GetMapping("/test5")
    public void test5(@RequestParam("id") Long id){
        userService2.methodB(id);
    }
}
