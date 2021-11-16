package com.yunus.dao;

import com.yunus.pojo.domain.Order;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


/**
 * @author gaoyunfeng
 */
@Repository
public class OrderDaoImpl implements OrderDao {

    Map<String, Order> db = new HashMap<>();

    /**
     * 保存
     *
     * @param order
     * @return
     */
    @Override
    public int save(Order order) {
        if (Objects.isNull(order) || StringUtils.isEmpty(order.getId())) {
            throw new IllegalArgumentException("order field id is null or empty");
        }
        db.put(order.getId(), order);
        return 1;
    }
}
