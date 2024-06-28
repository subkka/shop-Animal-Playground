package com.playground.admin_page.main.order.dto.order;

public enum OrderStatus {
    주문취소("주문취소"),
    입금전("입금전"),
    입금후("입금후"),
    배송중("배송중"),
    배송완료("배송완료");

    private String status;

    OrderStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
