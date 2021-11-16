package com.yunus.domain;

import com.yunus.enums.OrderStatus;
import lombok.Data;

@Data
public class Order {

    private Integer id;
    private OrderStatus status;
}
