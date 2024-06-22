package com.playground.admin_page.main.order.dao;

import com.playground.admin_page.main.order.dto.order.OrderDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    List<OrderDto> findAllOrder();
}