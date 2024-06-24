package com.playground.admin_page.login.model.service;

import com.playground.admin_page.login.model.dto.AdminDto;
import com.playground.admin_page.login.model.dao.AdminMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LoginQueryService {
    private final AdminMapper memberMapper;

    public AdminDto findByLoginInfo(String username, String password) {
        return memberMapper.findByLoginInfo(username, password);
    }
}
