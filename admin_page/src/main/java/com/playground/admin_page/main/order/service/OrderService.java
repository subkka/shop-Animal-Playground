package com.playground.admin_page.main.order.service;

import com.playground.admin_page.main.order.dao.OrderMapper;
import com.playground.admin_page.main.order.dto.order.CancelDto;
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

    public List<OrderDetailDto> informationProductDetail(int id) {
        return orderMapper.informationProductDetail(id);
    }

    public int statusChange(int orderId) {
        return orderMapper.statusChange(orderId);
    }

    public int insertCancel(int orderId) {
        return orderMapper.insertCancel(orderId);
    }

    public List<CancelDto> cancelInformation() {
        return orderMapper.cancelInformation();
    }
}