package com.yunus.pojo.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author gaoyunfeng
 * @Description: 用户实体
 * @date 2020/7/1715:57
 */
@Data
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private LocalDateTime createTime;
    private Integer weight;
    private Integer cityId;
}
