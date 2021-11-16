package com.yunus.service;

import com.yunus.dao.OrderDao;
import com.yunus.pojo.convert.OrderMapper;
import com.yunus.pojo.domain.Order;
import com.yunus.pojo.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author gaoyunfeng
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;


    @Override
    public Order createOrder(OrderDTO orderDTO) {
        // process business
        Order order = OrderMapper.INSTANCE.dtoToOrder(orderDTO);
        System.out.println(orderDao.save(order));
        return order;
    }
}
