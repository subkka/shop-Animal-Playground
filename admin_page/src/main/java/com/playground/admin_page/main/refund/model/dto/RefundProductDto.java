package com.playground.admin_page.main.refund.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefundProductDto {
    private Long refundProductId;
    private int orderProductId;
    private Long refundId;
}
