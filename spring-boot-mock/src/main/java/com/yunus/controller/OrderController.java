package com.yunus.controller;

import com.yunus.pojo.domain.Order;
import com.yunus.pojo.dto.OrderDTO;
import com.yunus.service.OrderService;
import org.springframework.web.bind.annotation.*;

/**
 * @author gaoyunfeng
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order create(@RequestBody OrderDTO params) {
        return orderService.createOrder(params);
    }

}
