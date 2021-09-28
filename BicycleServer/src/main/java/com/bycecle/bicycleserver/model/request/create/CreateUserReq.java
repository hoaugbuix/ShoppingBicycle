package com.bycecle.bicycleserver.model.request.create;

import lombok.Data;

@Data
public class CreateUserReq {
    private String firstName;

    private String lastName;

    private String avatar;

    private String username;

    private String password;

    private String email;
}
