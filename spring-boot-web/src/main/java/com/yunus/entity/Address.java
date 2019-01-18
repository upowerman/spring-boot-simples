package com.yunus.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
@Accessors(chain = true)
public class Address implements Serializable {

    private static final long serialVersionUID = -4114167893141625557L;
    private Integer id;
    private String name;
    private String city;
    private String code;

}
