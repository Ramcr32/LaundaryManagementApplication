package com.laundaryApplication.LaundaryManagingApplication.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class UserDTO {
    @Email
    private String email;
    @NotNull
    private String password;

}
