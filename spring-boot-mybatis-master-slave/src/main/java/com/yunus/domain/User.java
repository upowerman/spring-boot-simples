package com.yunus.domain;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author gaoyunfeng
 */
@Data
public class User {
    private long id;
    private String name;
    private int age;
    private String address;
    private int male;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
