package com.bycecle.bicycleserver.service.Impl;

import com.bycecle.bicycleserver.dao.RoleDAO;
import com.bycecle.bicycleserver.dao.UserDAO;
import com.bycecle.bicycleserver.entity.RoleEntity;
import com.bycecle.bicycleserver.entity.UserEntity;
import com.bycecle.bicycleserver.exception.DuplicateRecordException;
import com.bycecle.bicycleserver.model.converter.UserConvert;
import com.bycecle.bicycleserver.model.request.create.CreateUserReq;
import com.bycecle.bicycleserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO<UserEntity> userDAO;

    @Autowired
    private RoleDAO<RoleEntity> roleDAO;

    @Override
    public UserEntity save(CreateUserReq req) {
        // check exist
        UserEntity user = userDAO.findByEmail(req.getEmail());
        if (user != null){
            throw new DuplicateRecordException("Tài khoản đã tồn tại!");
        }
        RoleEntity role = roleDAO.findByRoleName("user");
        if (role != null) {
            user.setRoles(Collections.singleton(role));
        }
        user = UserConvert.toEntity(req);
        return user;
    }

    @Override
    public List<UserEntity> findAll() {
        return userDAO.findAll();
    }

    @Override
    public UserEntity findById(int id) {
        return userDAO.findById(id);
    }
}
