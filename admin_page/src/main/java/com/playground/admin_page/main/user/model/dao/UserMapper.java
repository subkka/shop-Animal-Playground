package com.playground.admin_page.main.user.model.dao;

import com.playground.admin_page.main.user.model.dto.UserDto;
import com.playground.admin_page.main.user.model.dto.UserEmailAble;
import com.playground.admin_page.main.user.model.dto.UserPet;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserDto> findAll();

    List<UserDto> findById(Long userNo);
    List<UserDto> findByPet(UserPet userPet);

    List<UserDto> findByEmailAble(UserEmailAble userEmailAble);
    void setDormant();

    List<UserDto> findByUsername(String username);
}
