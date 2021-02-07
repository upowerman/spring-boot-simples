package com.yunus.controller;

import com.yunus.common.NoAPIResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2021/2/5 17:53
 */
@RestController
@RequestMapping("/demo")
public class DemoController {


    @GetMapping("/echo")
    public String echo(String echo) {
        return echo;
    }
}
