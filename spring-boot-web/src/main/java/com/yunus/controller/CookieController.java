package com.yunus.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: gaoyunfeng
 * @date: 2018/11/30
 */
@RestController
@RequestMapping
public class CookieController {

    public void cookieTest(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("jwt", "salt");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(-1);
        response.addCookie(cookie);
    }
}
