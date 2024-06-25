package com.playground.admin_page.main.order.dto.order;

public enum OrderStatus {
    CANCEL("주문취소"),
    PENDING("입금전"),
    PAID("입금후"),
    DELIVERING("배송중"),
    COMPLETE("배송완료");

    private String status;

    OrderStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
