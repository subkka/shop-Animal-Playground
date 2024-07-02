package com.playground.admin_page.main.user.model.dao;

import com.playground.admin_page.main.user.model.dto.UserDto;
import com.playground.admin_page.main.user.model.dto.UserEmailAble;
import com.playground.admin_page.main.user.model.dto.UserPet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void testFindAll() {
        List<UserDto> users = userMapper.findAll();
        System.out.println(users);
        assertThat(users)
                .isNotNull()
                .isNotEmpty()
                .allMatch((user)->user!=null);
    }
    @Test
    public void testFindById() {
        List<UserDto> users = userMapper.findById(1L);
        System.out.println(users);
        assertThat(users).isNotEmpty()
                .isNotNull()
                .allMatch((user) -> user != null);
    }


    @Test
    public void testFindByPet() {
        List<UserDto> users = userMapper.findByPet(UserPet.Dog);
        System.out.println(users);
        assertThat(users).isNotEmpty()
                .isNotNull()
                .allMatch((user) -> user != null);
    }

    @Test
    public void testFindByEmailAble() {
        List<UserDto> users = userMapper.findByEmailAble(UserEmailAble.Y);
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