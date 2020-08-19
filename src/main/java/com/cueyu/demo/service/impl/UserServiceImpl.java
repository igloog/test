package com.cueyu.demo.service.impl;

import com.cueyu.demo.entity.User;
import com.cueyu.demo.mapper.UserMapper;
import com.cueyu.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserbyId(int id) {
        User user = userMapper.getById(id);
        return user;
    }

    @Override
    public int registerUser(User user) {
        int result = userMapper.addUser(user);
        return result;
    }

    @Override
    public User selectUserbyName(String username) {
        User user = userMapper.getByname(username);
        return user;
    }
}
