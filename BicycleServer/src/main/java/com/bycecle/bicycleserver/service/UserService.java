package com.bycecle.bicycleserver.service;

import com.bycecle.bicycleserver.entity.UserEntity;
import com.bycecle.bicycleserver.model.request.create.CreateUserReq;
import com.bycecle.bicycleserver.model.request.update.ChangePasswordReq;
import com.bycecle.bicycleserver.model.request.update.UpdateUserReq;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserEntity save(CreateUserReq req);

    UserEntity update(UserEntity user, UpdateUserReq req);

    void changePassword(UserEntity user, ChangePasswordReq req);

    List<UserEntity> findAll();

    UserEntity findById(int id);
}
