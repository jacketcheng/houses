package com.houses.service.impl;

import com.houses.common.model.User;
import com.houses.mapper.UserMapper;
import com.houses.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUsers() {
        return userMapper.selectUsers();
    }
}
