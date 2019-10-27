package com.yunus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: gaoyunfeng
 * @date: 2019/3/1
 */
@RestController
@RequestMapping("/hello")
public class DockerController {

    @GetMapping
    public Map<String, String> hello(String name) {
        Map<String, String> map = new HashMap<>(1);
        map.put("hello", name);
        return map;
    }
}
