package com.yunus.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {
    private String name;
    private String phoneNum;
    private String address;
    private BigDecimal totalPrice;
}
