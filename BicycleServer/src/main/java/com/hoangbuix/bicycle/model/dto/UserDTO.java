package com.hoangbuix.bicycle.model.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserDTO {
    private int id;
    private String firstName;

    private String lastName;

    private String avatar;

    private String username;

    private String password;

    private String email;

    private int activeFlag;

    private Date createdDate;


    private Date updatedDate;

    private List<String> role;
}
