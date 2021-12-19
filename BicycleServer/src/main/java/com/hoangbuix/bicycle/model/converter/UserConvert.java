package com.hoangbuix.bicycle.model.converter;

import com.hoangbuix.bicycle.entity.RoleEntity;
import com.hoangbuix.bicycle.entity.UserEntity;
import com.hoangbuix.bicycle.model.dto.UserDTO;
import com.hoangbuix.bicycle.model.request.create.CreateUserReq;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


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
        if (entity.getId() != null) {
            dto.setId(entity.getId());
        }
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setAvatar(entity.getAvatar());
        dto.setEmail(entity.getEmail());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setActiveFlag(entity.getActiveFlag());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        if (entity.getRoles() != null) {
            for (RoleEntity role : entity.getRoles()){
                List<String> lstRole = new ArrayList<>();
                lstRole.add(role.getRoleName());
                dto.setRole(lstRole);
            }
        }
        return dto;
    }
}
