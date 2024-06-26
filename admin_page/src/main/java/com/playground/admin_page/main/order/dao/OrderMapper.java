package com.playground.admin_page.main.order.dao;

import com.playground.admin_page.main.order.dto.order.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    List<OrderDto> findAllOrder();

    List<OrderDto> findByStatus(String status);

    OrderDetailDto productDetail(int orderId);

    List<OrderDetailDto> stockCheck(int orderId);

    OrderDetailDto informationProductDetail(int id);

    int statusChange(int orderId);

    int insertCancel(int orderId);

    OrderDto findByOrderId(int orderId);

    List<CancelDto> cancelInformation();

    int getSales();

    int getOrderCount();

    SalesDto salesInformation();

    List<OrderDetailDto> findComplete();


    List<String> getCategoryList();

    List<Integer> getCountByCategory();

    List<String> getPetList();

    List<Integer> getCountByUserPet();

    List<String> getKindStatus();

    List<Integer> getCountStatus();

    String getRefund();
}