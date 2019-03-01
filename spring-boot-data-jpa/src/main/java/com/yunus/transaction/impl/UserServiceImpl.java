package com.yunus.transaction.impl;

import com.yunus.dao.UserRepository;
import com.yunus.entity.User;
import com.yunus.service.AsynService;
import com.yunus.transaction.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: gaoyunfeng
 * @date: 2019/2/27
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AsynService asynService;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    @Override
    public void transactionTest1() {
        User user = new User();
        user.setAge(10).setAddress("北京").setMale("男").setName("张三");
        userRepository.save(user);
        //transactionTest2(user.getId());
        asynService.getUserById(user.getId());
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    @Override
    public void transactionTest2(Long id) {
        User one = userRepository.getOne(id);
        System.out.println(one);
    }
}
