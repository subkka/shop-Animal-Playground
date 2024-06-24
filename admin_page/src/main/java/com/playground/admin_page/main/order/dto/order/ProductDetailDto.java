package com.playground.admin_page.main.order.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor@AllArgsConstructor
public class ProductDetailDto {

    private int orderProductId;
    private int orderId;
    private int productId;
    private int quantity;
    private String productName;
    private int productPrice;
    private int amount;
}