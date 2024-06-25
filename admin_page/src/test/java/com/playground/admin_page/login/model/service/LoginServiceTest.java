package com.playground.admin_page.login.model.service;

import com.playground.admin_page.login.model.dao.AdminAccountMapper;
import com.playground.admin_page.login.model.dto.AdminAccountDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class LoginServiceTest {
    @Autowired
    private AdminAccountMapper adminAccountMapper;

    @Test
    @DisplayName("아이디 비밀번호 일치 여부 확인")
    void test1() {
        // given
        String id = "admin01";
        String password = "12341234";
        // when
        AdminAccountDto adminAccountDto = adminAccountMapper.findByLoginInfo(id, password);
        // then
        System.out.println(adminAccountDto.toString());
        assertThat(adminAccountDto)
                .isNotNull()
                .satisfies(
                        (_adminAccountDto) -> assertThat(_adminAccountDto.getAdminAccountNo()).isPositive(),
                        (_adminAccountDto) -> assertThat(_adminAccountDto.getAdminId()).isEqualTo(id),
                        (_adminAccountDto) -> assertThat(_adminAccountDto.getPassword()).isEqualTo(password),
                        (_adminAccountDto) -> assertThat(_adminAccountDto.getPermission()).isNotNull()
                );
    }
}