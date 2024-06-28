package com.playground.admin_page.main.refund.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefundDto {
    private Long refundId;
    private Long orderId;
    private LocalDateTime applicationDate;
    private String processStatus;
    private String refundReasonType;
    private String refundReasonDetail;
    private String refundYn;
}
