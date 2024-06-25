package com.playground.admin_page.main.user.model.service;

import com.playground.admin_page.main.user.model.dao.UserMapper;
import com.playground.admin_page.main.user.model.dto.InfoDto;
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
    public List<InfoDto> findAll(){
        return userMapper.findAll();
    }
    public List<InfoDto> findById(Long userNo){
        return userMapper.findById(userNo);

    }
    public List<InfoDto> findByPet(UserPet userPet){
        return userMapper.findByPet(userPet);
    }

    public List<InfoDto> findByEmailAble(UserEmailAble userEmailAble) {
        return userMapper.findByEmailAble(userEmailAble);
    }

    public void setDormant() {
        userMapper.setDormant();
    }


}
