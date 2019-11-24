package com.yunus.service;

import com.yunus.domain.User;
import com.yunus.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author gaoyunfeng
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    @Transactional(rollbackFor = Exception.class)
    public void transactional1(){
        User user = userMapper.getOneById(1L);
        user.setName("slave");
        userMapper.update(user);
    }
}
