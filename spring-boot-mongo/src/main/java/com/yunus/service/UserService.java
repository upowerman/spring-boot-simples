package com.yunus.service;

import com.yunus.pojo.domain.User;
import com.yunus.repository.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private MongoTemplate mongoTemplate;
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
        Query query = new Query(Criteria.where("id").is(user.getId()));
        Update update = new Update().set("address",user.getAddress());
        mongoTemplate.updateFirst(query, update, user.getClass());
    }

    public void update2(User user){
        userMongoRepository.save(user);
    }

    public List<User> query(String address) {
        return userMongoRepository.findByAddressLike(address);
    }

    public List<User> queryPhone(String phone) {
        return userMongoRepository.findByPhoneAfter(phone);
    }
}
