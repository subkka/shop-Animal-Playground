package com.playground.admin_page.main.order.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@NoArgsConstructor@AllArgsConstructor
public class OrderItemDto {

    private int orderProdcutId;
    private int orderId;
    private int productId;
    private int quantity;

}