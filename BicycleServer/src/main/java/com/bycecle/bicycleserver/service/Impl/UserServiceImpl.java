package com.bycecle.bicycleserver.service.Impl;

import com.bycecle.bicycleserver.dao.UserDAO;
import com.bycecle.bicycleserver.entity.UserEntity;
import com.bycecle.bicycleserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO<UserEntity> userDAO;

    @Override
    public List<UserEntity> findAll() {
        return userDAO.findAll();
    }

    @Override
    public UserEntity findById(int id) {
        return userDAO.findById(id);
    }
}
