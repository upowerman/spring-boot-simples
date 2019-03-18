package com.yunus.controller;

import com.yunus.service.SyncTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: gaoyunfeng
 * @date: 2019/3/18
 */
@RestController
public class EmployeeController {
    @Autowired
    private SyncTransaction syncTransaction;

    @GetMapping("/add")
    public void addEmployee() {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> syncTransaction.increaseMoney(1L)).start();
        }
    }
}
