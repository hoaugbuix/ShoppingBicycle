package com.bycecle.bicycleserver.service;

import com.bycecle.bicycleserver.entity.UserEntity;
import com.bycecle.bicycleserver.model.request.create.CreateUserReq;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserEntity save(CreateUserReq req);

    List<UserEntity> findAll();

    UserEntity findById(int id);
}
