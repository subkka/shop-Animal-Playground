package com.playground.admin_page.login.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminAccountDto {
    private Long adminAccountNo;
    private String adminId;
    private String password;
    private Permission permission;
}
