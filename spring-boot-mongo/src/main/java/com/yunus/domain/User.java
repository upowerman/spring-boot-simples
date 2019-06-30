package com.yunus.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
public class User implements Serializable {


    private static final long serialVersionUID = -8534475243645539894L;
    @Id
    private Integer id;
    private String name;
    private String address;
    private String phone;
    private Short gender;
}
