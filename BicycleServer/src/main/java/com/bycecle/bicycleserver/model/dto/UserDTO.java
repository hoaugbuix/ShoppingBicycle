package com.bycecle.bicycleserver.model.dto;

import com.bycecle.bicycleserver.entity.RoleEntity;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserDTO {
    private String firstName;

    private String lastName;

    private String avatar;

    private String username;

    private String password;

    private String email;

    private int activeFlag;

    private Date createdDate;


    private Date updatedDate;

    private String role;
}
