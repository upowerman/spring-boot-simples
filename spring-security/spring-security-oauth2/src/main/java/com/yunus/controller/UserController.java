package com.yunus.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaoyunfeng
 */
@RestController
public class UserController {

    @GetMapping("index")
    public Object index(Authentication authentication){
        return authentication;
    }
}
