package com.playground.admin_page.main.order.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long productId;
    private String productName;
    private String category;
    private byte[] productImage;
    private String productDesc;
    private int price;
    private int amount;
    private boolean isDisplay;
    private String productStatus;
    private LocalDateTime createdAt;
}