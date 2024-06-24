package com.playground.admin_page.main.order.dao;

import com.playground.admin_page.main.order.dto.order.CancelDto;
import com.playground.admin_page.main.order.dto.order.OrderDetailDto;
import com.playground.admin_page.main.order.dto.order.OrderDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    List<OrderDto> findAllOrder();

    List<OrderDto> findByStatus(String status);

    List<OrderDetailDto> productDetail(int orderId);

    List<OrderDetailDto> stockCheck(int orderId);

    List<OrderDetailDto> informationProductDetail(int id);

    int statusChange(int orderId);

    int insertCancel(int orderId);

    OrderDto findByOrderId(int orderId);

    List<CancelDto> cancelInformation();
}