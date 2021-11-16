package com.yunus.service;

import com.yunus.pojo.domain.Order;
import com.yunus.pojo.dto.OrderDTO;

public interface OrderService {

    Order createOrder(OrderDTO order);

}
