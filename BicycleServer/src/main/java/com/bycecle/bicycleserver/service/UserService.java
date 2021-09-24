package com.bycecle.bicycleserver.service;

import com.bycecle.bicycleserver.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<UserEntity> findAll();

    UserEntity findById(int id);
}
