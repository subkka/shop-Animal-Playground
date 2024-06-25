package com.playground.admin_page.main.user.model.dao;

import com.playground.admin_page.main.user.model.dto.InfoDto;
import com.playground.admin_page.main.user.model.dto.UserEmailAble;
import com.playground.admin_page.main.user.model.dto.UserPet;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<InfoDto> findAll();

    List<InfoDto> findById(Long userNo);
    List<InfoDto> findByPet(UserPet userPet);

    List<InfoDto> findByEmailAble();
    void setDormant();
}
