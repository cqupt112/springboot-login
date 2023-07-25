package com.ruanko.springboothelloworld.service;

import org.springframework.stereotype.Service;
import com.ruanko.springboothelloworld.mapper.UserMapper;
import com.ruanko.springboothelloworld.entity.User;

import javax.annotation.Resource;

@Service
public class UserService {
    //将dao层属性注入service层
    @Resource
    private UserMapper userMapper;

    public User LoginIn(String username, String password) {
        return userMapper.getInfo(username,password);
    }

    public void Insert(String username,String password){
        userMapper.saveInfo(username, password);
    }

}
