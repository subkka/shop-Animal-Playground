package com.playground.admin_page.main.user.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public enum UserEmailAble {
    Y("1", true),
    N("0", false);

    private String a;
    private boolean b;

    UserEmailAble(String a, boolean b) {
        this.a = a;
        this.b = b;
    }
    public String getA(){
        return a;
    }
    public boolean isB(){
        return b;
    }
}
