package com.hoangbuix.bicycle.model.request.update;

import lombok.Data;

@Data
public class UpdateUserReq {
    private String firstName;

    private String lastName;

    private String avatar;

    private String email;
}
