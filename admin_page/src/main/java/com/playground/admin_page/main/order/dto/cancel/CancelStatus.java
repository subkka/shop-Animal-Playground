package com.playground.admin_page.main.order.dto.cancel;

public enum CancelStatus {
    Processing("처리중"),
    Processed("처리 완료");

    private String cancelStatus;

    public String getCancelStatus() {
        return cancelStatus;
    }

    CancelStatus(String cancelStatus) {
        this.cancelStatus = cancelStatus;
    }
}
