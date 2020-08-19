package com.cueyu.demo.service;

import com.cueyu.demo.entity.User;

public interface UserService {

    User selectUserbyId(int id);

    int registerUser(User user);

    User selectUserbyName(String username);
}
