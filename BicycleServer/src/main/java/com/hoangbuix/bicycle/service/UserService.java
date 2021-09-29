package com.hoangbuix.bicycle.service;

import com.hoangbuix.bicycle.entity.UserEntity;
import com.hoangbuix.bicycle.model.request.create.CreateUserReq;
import com.hoangbuix.bicycle.model.request.update.ChangePasswordReq;
import com.hoangbuix.bicycle.model.request.update.UpdateUserReq;
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
