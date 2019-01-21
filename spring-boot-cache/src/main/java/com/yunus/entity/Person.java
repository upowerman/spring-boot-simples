package com.yunus.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: gaoyunfeng
 * @date: 2019/1/18
 */
@Data
public class Person implements Serializable{
    private static final long serialVersionUID = 640472271706310788L;
    private Integer id;
    private String name;
    private String email;
    private String mobile;
    private String address;
    private String age;
    private String birthday;
}
