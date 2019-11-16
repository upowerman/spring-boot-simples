package com.yunus.controller;

import com.yunus.domain.User;
import com.yunus.mapper.UserMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author gaoyunfeng
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping
    public List<User> list(@RequestParam(required = false) String ids,
                           @RequestParam(defaultValue = "0", required = false) Integer offset,
                           @RequestParam(defaultValue = "10", required = false) Integer limit) {
        RowBounds rowBounds = new RowBounds(offset, limit);
        return userMapper.list(ids, rowBounds);
    }
}
