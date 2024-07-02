package com.playground.admin_page.main.user.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long userId;
    private String userName;
    private String userEmail;
    private String address;
    private LocalDate joinDate;
    private LocalDate lastConnect;
    private char userEmailAble;
    private String userPet;
    private char dormantUser;

    public String getUserEmailAbleToString() {
        return switch (this.userEmailAble) {
            case '0' -> "";
            case '1' -> "동의";
            default -> "";
        };
    }

    public String getUserPetToString() {
        return switch (this.userPet) {
            case "Dog" -> "강아지";
            case "Cat" -> "고양이";
            default -> "";
        };
    }

    public String getDormantUserToString() {
        return switch (this.dormantUser) {
            case '0' -> "";
            case '1' -> "휴면";
            default -> "";
        };
    }
}
