package com.playground.admin_page.main.order.dto.cancel;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data@AllArgsConstructor@NoArgsConstructor
public class OrderCancelDto {

    private int cancelId;
    private int orderId;
    private String cancelReason;
    private CancelStatus cancelStatus;
    private LocalDateTime cancelDate;
}