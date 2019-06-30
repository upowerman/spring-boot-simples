package com.yunus.service;

import com.yunus.domain.User;
import com.yunus.repository.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserMongoRepository userMongoRepository;

    public List<User> list() {
        return userMongoRepository.findAll();
    }

    public void save(User user) {
        userMongoRepository.save(user);
    }

    /**
     * 不支持事务
     *
     * @param user
     */
    public void update(User user) {
        userMongoRepository.deleteById(user.getId());
        userMongoRepository.save(user);
    }

    public List<User> query(String address) {
        return userMongoRepository.findByAddressLike(address);
    }

    public List<User> queryPhone(String phone) {
        return userMongoRepository.findByPhoneAfter(phone);
    }
}
