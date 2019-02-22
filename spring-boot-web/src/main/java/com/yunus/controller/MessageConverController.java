package com.yunus.controller;

import cn.hutool.core.date.DateUtil;
import com.yunus.annotation.Login;
import com.yunus.constant.Gender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author: gaoyunfeng
 * @date: 2018/11/28
 */
@RestController
public class MessageConverController {

    @GetMapping("/test/converter/enum")
    public Gender convert(Gender gender) {
        return gender;
    }


    @GetMapping("/test/converter/date")
    @Login
    public String convertDate(Date date) {
        return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
    }
}
