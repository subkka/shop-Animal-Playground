package com.playground.admin_page.main.user.model.dao;

import com.playground.admin_page.main.user.model.dto.InfoDto;
import com.playground.admin_page.main.user.model.dto.UserEmailAble;
import com.playground.admin_page.main.user.model.dto.UserPet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void testFindAll() {
        List<InfoDto> users = userMapper.findAll();
        System.out.println(users);
        assertThat(users)
                .isNotNull()
                .isNotEmpty()
                .allMatch((user)->user!=null);
    }
    @Test
    public void testFindById() {
        List<InfoDto> users = userMapper.findById(1L);
        System.out.println(users);
        assertThat(users).isNotEmpty()
                .isNotNull()
                .allMatch((user) -> user != null);
    }


    @Test
    public void testFindByPet() {
        List<InfoDto> users = userMapper.findByPet(UserPet.Dog);
        System.out.println(users);
        assertThat(users).isNotEmpty()
                .isNotNull()
                .allMatch((user) -> user != null);
    }

    @Test
    public void testFindByEmailAble() {
        List<InfoDto> users = userMapper.findByEmailAble(UserEmailAble.Y);
        System.out.println(users);
        assertThat(users).isNotEmpty()
                .isNotNull()
                .allMatch((user) -> user != null);
    }

    @Test
    public void testSetDormant() {
        userMapper.setDormant();
    }

}