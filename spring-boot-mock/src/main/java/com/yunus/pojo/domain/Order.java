package com.yunus.pojo.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order {

    private String id;
    private String name;
    private String phoneNum;
    private String address;
    private BigDecimal totalPrice;
}
