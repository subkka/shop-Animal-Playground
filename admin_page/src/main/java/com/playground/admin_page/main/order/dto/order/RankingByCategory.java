package com.playground.admin_page.main.order.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor
public class RankingByCategory {
    private int orderId;
    private int orderProductId;
    private String productName;
    private String category ;
    private int count ;
    private int ranking ;

}