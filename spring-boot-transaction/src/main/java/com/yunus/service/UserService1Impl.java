package com.yunus.service;

import com.yunus.dao.UserMapper;
import com.yunus.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: gaoyunfeng
 * @date: 2019/3/15
 */
@Service
public class UserService1Impl implements UserService1 {


    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void methodA(Long id) {
        User user = userMapper.selectById(id);
        user.setAge(11);
        userMapper.updateById(user);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void methodB(Long id) {
        User one = userMapper.selectById(id);
        one.setAge(19);
        userMapper.updateById(one);
        throw new RuntimeException("抛出异常");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void methodC(Long id) {
        User user = userMapper.selectById(id);
        user.setAge(11);
        userMapper.updateById(user);
        methodB(id);
        user.setAge(222);
        userMapper.updateById(user);
    }
}
