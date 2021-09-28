package com.bycecle.bicycleserver.model.converter;

import com.bycecle.bicycleserver.entity.RoleEntity;
import com.bycecle.bicycleserver.entity.UserEntity;
import com.bycecle.bicycleserver.model.dto.UserDTO;
import com.bycecle.bicycleserver.model.request.create.CreateUserReq;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.Collections;

public class UserConvert {
    public static UserEntity toEntity(CreateUserReq req) {
        UserEntity entity = new UserEntity();
        entity.setFirstName(req.getFirstName());
        entity.setLastName(req.getLastName());
        entity.setAvatar(req.getAvatar());
        entity.setUsername(req.getUsername());
        // hash password
        String hash = BCrypt.hashpw(req.getPassword(), BCrypt.gensalt(12));
        entity.setPassword(hash);
        entity.setEmail(req.getEmail());
        return entity;
    }

    public static UserDTO toDTO(UserEntity entity) {
        UserDTO dto = new UserDTO();
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setAvatar(entity.getAvatar());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setActiveFlag(entity.getActiveFlag());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        for (RoleEntity role : entity.getRoles()){
            dto.setRole(role.getRoleName());
        }
        return dto;
    }
}
