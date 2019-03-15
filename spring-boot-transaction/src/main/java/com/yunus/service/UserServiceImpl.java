package com.yunus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: gaoyunfeng
 * @date: 2019/3/15
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserService1 userService1;
    @Autowired
    private UserService2 userService2;

    @Override
    public void test1(Long id) {
        userService1.methodC(id);
    }

    @Override
    public void test2(Long id) {
        userService1.methodA(id);
    }

    @Override
    public void test3(Long id) {
        userService1.methodB(id);
    }
}
