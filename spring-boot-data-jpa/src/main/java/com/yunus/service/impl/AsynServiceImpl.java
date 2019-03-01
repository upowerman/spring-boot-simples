package com.yunus.service.impl;

import com.yunus.dao.UserRepository;
import com.yunus.entity.User;
import com.yunus.service.AsynService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: gaoyunfeng
 * @date: 2019/2/27
 */
@Service
public class AsynServiceImpl implements AsynService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Async("taskExecutor")
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NEVER)
    public void getUserById(Long id) {
        User one = userRepository.getOne(id);
        System.out.println(one);
    }
}
