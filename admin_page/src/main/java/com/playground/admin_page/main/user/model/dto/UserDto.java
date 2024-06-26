package com.playground.admin_page.main.user.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long userId;
    private String userName;
    private String userEmail;
    private String address;
    private Date joinDate;
    private Date lastConnect;
    private char userEmailAble;
    private String userPet;
    private char dormantUser;
}
