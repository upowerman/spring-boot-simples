package com.yunus.pojo.convert;

import com.yunus.pojo.domain.Order;
import com.yunus.pojo.dto.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author gaoyunfeng
 */
@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    /**
     * dto to domain convertor
     *
     * @param source source
     * @return target
     */
    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID().toString())")
    Order dtoToOrder(OrderDTO source);
}
