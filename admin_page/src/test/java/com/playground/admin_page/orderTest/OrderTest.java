package com.playground.admin_page.orderTest;

import com.playground.admin_page.main.order.dao.OrderMapper;
import com.playground.admin_page.main.order.dto.order.OrderDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class OrderTest {

    @Autowired
    private OrderMapper ordermapper;

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
}