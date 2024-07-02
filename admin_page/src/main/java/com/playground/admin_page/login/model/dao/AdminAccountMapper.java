package com.playground.admin_page.login.model.dao;

import com.playground.admin_page.login.model.dto.AdminAccountDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminAccountMapper {
    AdminAccountDto findByLoginInfo(String id, String password);
}
