package com.playground.admin_page.login.model.service;

import com.playground.admin_page.login.model.dao.AdminAccountMapper;
import com.playground.admin_page.login.model.dto.AdminAccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LoginService {
    private final AdminAccountMapper adminAccountMapper;

    public AdminAccountDto findByLoginInfo(String id, String password) {
        return adminAccountMapper.findByLoginInfo(id, password);
    }
}
