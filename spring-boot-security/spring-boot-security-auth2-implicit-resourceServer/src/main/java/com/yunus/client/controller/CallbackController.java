package com.yunus.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author M4500
 */
@RestController
@RequestMapping
public class CallbackController {

    @GetMapping("/callback")
    public String login() {
        return "假装这里有一个页面";
    }

}
