package com.playground.admin_page.login.model.dao;

import com.playground.admin_page.login.model.dto.AdminDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    AdminDto findByLoginInfo(String username, String password);
}
