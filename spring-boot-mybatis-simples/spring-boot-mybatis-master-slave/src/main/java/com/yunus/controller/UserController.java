package com.yunus.controller;

import com.yunus.pojo.domain.User;
import com.yunus.mapper.UserMapper;
import com.yunus.service.UserService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gaoyunfeng
 */
@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> list(@RequestParam(required = false) String ids,
                           @RequestParam(defaultValue = "0", required = false) Integer offset,
                           @RequestParam(defaultValue = "10", required = false) Integer limit) {
        RowBounds rowBounds = new RowBounds(offset, limit);
        return userMapper.list(ids, rowBounds);
    }

    @GetMapping("/transaction")
    public void transaction() {
        userService.transactional1();
    }

    @GetMapping("/{id}")
    public User getOne(@PathVariable("id")int id){
        return userMapper.selectOneById(id);
    }

    @DeleteMapping("/{id}")
    public Map<String,Object> delete(@PathVariable("id")Integer id){
        Map<String,Object> result = new HashMap<>();
        result.put("ok","success");
        return result;
    }
}
