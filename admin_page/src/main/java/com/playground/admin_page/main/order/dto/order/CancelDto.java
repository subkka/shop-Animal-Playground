package com.playground.admin_page.main.order.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CancelDto {
    private int cancelId;
    private String cancelReason;
    private int orderId;
    private String processStatus;
    private LocalDateTime cancelDate;
}