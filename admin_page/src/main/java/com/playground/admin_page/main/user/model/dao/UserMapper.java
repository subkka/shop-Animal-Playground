package com.playground.admin_page.main.user.model.dao;

import com.playground.admin_page.main.user.model.dto.UserDto;
import com.playground.admin_page.main.user.model.dto.UserEmailAble;
import com.playground.admin_page.main.user.model.dto.UserPet;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserDto> findAll();

    List<UserDto> findByUsername(String username);

    List<UserDto> findByPet(UserPet userPet);

    List<UserDto> findByEmailAble(UserEmailAble userEmailAble);
}
