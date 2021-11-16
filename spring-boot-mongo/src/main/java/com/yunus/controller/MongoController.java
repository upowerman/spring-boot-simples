package com.yunus.controller;


import com.yunus.pojo.domain.User;
import com.yunus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mongo")
public class MongoController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> list(){
        return userService.list();
    }


    @PostMapping("/users")
    public void save(@RequestBody User user){
        userService.save(user);
    }

    @PutMapping("/users")
    public void update(@RequestBody User user){
        userService.update(user);
    }

    @GetMapping("/users/address")
    public List<User> query(String address){
        return userService.query(address);
    }

    @GetMapping("/users/phone")
    public List<User> queryPhone(String phone){
        return userService.queryPhone(phone);
    }
}
