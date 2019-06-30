package com.yunus.repository;

import com.yunus.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserMongoRepository extends MongoRepository<User,Integer> {

    List<User> findByAddressLike(String address);

    List<User> findByPhoneAfter(String phone);
}
