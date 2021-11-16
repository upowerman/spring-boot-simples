package com.yunus.service;

import com.yunus.dao.UserMapper;
import com.yunus.pojo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: gaoyunfeng
 * @date: 2019/3/15
 */
@Service
public class UserService2Impl implements UserService2 {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void methodA(long id) {
        User user = new User();
        user.setId(id);
        user.setAddress("北极圈");
        userMapper.updateById(user);
        int result = 1/0;
    }

    @Override
    public void methodB(long id) {
        methodA(id);
    }
}
