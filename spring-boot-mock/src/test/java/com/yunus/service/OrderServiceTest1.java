package com.yunus.service;

import com.yunus.pojo.domain.Order;
import com.yunus.pojo.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;


/**
 * @author gaoyunfeng
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest1 {

    @Autowired
    private OrderService orderService;

    @Test
    public void testCreateOrder() {
        OrderDTO orderDTO = OrderDTO.builder().address("北京")
                .name("张三").phoneNum("10086")
                .totalPrice(new BigDecimal("23.89")).build();
        Order order = orderService.createOrder(orderDTO);
        log.info(order.toString());
    }

}
