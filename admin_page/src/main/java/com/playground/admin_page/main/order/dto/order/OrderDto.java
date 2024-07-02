package com.playground.admin_page.main.order.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private int orderId;
    private int userId;
    private LocalDateTime orderDate;
    private OrderStatus orderStatus;
    private int totalPrice;


}