package com.yunus.service;

import com.yunus.dao.OrderDao;
import com.yunus.pojo.convert.OrderMapper;
import com.yunus.pojo.domain.Order;
import com.yunus.pojo.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;


/**
 * Spring boot自身提供很多有用的工具类和注解用于测试应用，
 * 主要分两个模块：spring-boot-test包含核心组件，spring-boot-test-autoconfigure为测试提供自动配置。
 * 开发者只需要引用spring-boot-starter-test即可。它提供的测试模块中包含了Mockito。
 * Spring boot使用@MockBean和@SpyBean来定义Mockito的mock和spy。
 * SpringBoot提供的@MockBean注解，用于为ApplicationContext中的bean定义一个mock，
 * 你可以使用该注解添加新beans，或替换已存在的bean定义。该注解可直接用于测试类，也可用于测试类的字段，
 * 或用于@Configuration注解的类和字段。当用于字段时，创建mock的实例也会被注入。
 * Mock beans每次调用完测试方法后会自动重置。
 * <a src="https://www.cnblogs.com/ceshi2016/p/9550823.html"/>
 *
 * @author gaoyunfeng
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest4 {


    @MockBean
    private OrderDao orderDao;

    @SpyBean
    private OrderServiceImpl orderServiceOfInjectMocks;

    @Before
    public void before() {
        Mockito.when(orderDao.save(Mockito.any(Order.class))).thenReturn(1000);
    }

    @Test
    public void testCreateOrder() {
        OrderDTO orderDTO = OrderDTO.builder().address("北京")
                .name("张三").phoneNum("10086")
                .totalPrice(new BigDecimal("23.89")).build();
        Mockito.doReturn(OrderMapper.INSTANCE.dtoToOrder(orderDTO)).when(orderServiceOfInjectMocks).createOrder(orderDTO);
        orderServiceOfInjectMocks.createOrder(orderDTO);
        OrderDTO orderDTO2 = OrderDTO.builder().address("北京")
                .name("李四").phoneNum("10086")
                .totalPrice(new BigDecimal("23.89")).build();
        orderServiceOfInjectMocks.createOrder(orderDTO2);
    }

}
