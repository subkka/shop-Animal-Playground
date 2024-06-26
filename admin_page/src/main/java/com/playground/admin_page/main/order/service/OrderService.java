package com.playground.admin_page.main.order.service;

import com.playground.admin_page.main.order.dao.OrderMapper;
import com.playground.admin_page.main.order.dto.order.CancelDto;
import com.playground.admin_page.main.order.dto.order.OrderDetailDto;
import com.playground.admin_page.main.order.dto.order.OrderDto;
import com.playground.admin_page.main.order.dto.order.ProductDetailDto;
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


    public OrderDetailDto productDetail(int orderId) {
        return orderMapper.productDetail(orderId);
    }

    public OrderDetailDto informationProductDetail(int id) {
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

    public int getSales() {
        return orderMapper.getSales();
    }

    public int getOrderCount() {
        return orderMapper.getOrderCount();
    }

    public List<OrderDetailDto> findComplete() {
        return orderMapper.findComplete();
    }

    public List<String> getCategoryList() {
        return orderMapper.getCategoryList();
    }

    public List<Integer> getCountByCategory() {
        return orderMapper.getCountByCategory();
    }

    public List<String> getPetList() {
        return orderMapper.getPetList();
    }

    public List<Integer> getCountByUserPet() {
        return orderMapper.getCountByUserPet();
    }
}