package com.playground.admin_page.main.order.service;

import com.playground.admin_page.main.order.dao.OrderMapper;
import com.playground.admin_page.main.order.dto.order.OrderDetailDto;
import com.playground.admin_page.main.order.dto.order.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderMapper orderMapper;

    public List<OrderDto> findAllOrder() {
        return orderMapper.findAllOrder();
    }

    public List<OrderDto> findByStatus(String status) {
        return orderMapper.findByStatus(status);
    }


    public List<OrderDetailDto> productDetail(int orderId) {
        return orderMapper.productDetail(orderId);
    }

}