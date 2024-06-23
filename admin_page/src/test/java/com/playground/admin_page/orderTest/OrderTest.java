package com.playground.admin_page.orderTest;

import com.playground.admin_page.main.order.dao.OrderMapper;
import com.playground.admin_page.main.order.dto.order.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class OrderTest {


    private  OrderMapper ordermapper;
    @Autowired
    public OrderTest(OrderMapper ordermapper) {
        this.ordermapper = ordermapper;
    }

    @Test
    @DisplayName("모든 주문 내역 조회 ")
    void test1() {
        //given
        List<OrderDto> orders = ordermapper.findAllOrder();
        System.out.println(orders);
        //then
        assertThat(orders).isNotNull().allMatch(m -> m != null);

        //when
        //then
    }

    @Test
    @DisplayName("상태별 주문 조회")
    void test2() {
        //given
        String status = "PENDING";

        //when
        List<OrderDto> orders = ordermapper.findByStatus(status);
        System.out.println(orders);
        //then
        assertThat(orders).isNotNull().allMatch(m -> m != null);

    }

    @Test
    @DisplayName("제품 상세정보 출력하기 ")
    void test4() {
        //given
        int orderId = 1;
        //when
        List<OrderDetailDto> orders = ordermapper.productDetail(orderId);
        System.out.println(orders);
        //then
        ;
        assertThat(orders).isNotNull().allMatch(m -> m != null);
    }


}