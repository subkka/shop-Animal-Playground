package com.playground.admin_page.main.user.model.service;

import com.playground.admin_page.main.user.model.dao.UserMapper;
import com.playground.admin_page.main.user.model.dto.UserDto;
import com.playground.admin_page.main.user.model.dto.UserEmailAble;
import com.playground.admin_page.main.user.model.dto.UserPet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    public List<UserDto> findAll(){
        return userMapper.findAll();
    }
    public List<UserDto> findById(Long userId){
        return userMapper.findById(userId);

    }
    public List<UserDto> findByPet(UserPet userPet){
        return userMapper.findByPet(userPet);
    }

    public List<UserDto> findByEmailAble(UserEmailAble userEmailAble) {
        return userMapper.findByEmailAble(userEmailAble);
    }

    public void setDormant() {
        userMapper.setDormant();
    }


}
