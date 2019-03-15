package com.yunus.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: gaoyunfeng
 * @date: 2019/3/15
 */
@Service
public class UserService2Impl implements UserService2 {


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void methodA() {

    }

    @Override
    public void methodB() {

    }
}
