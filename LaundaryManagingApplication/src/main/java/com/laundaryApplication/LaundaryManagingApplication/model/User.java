package com.laundaryApplication.LaundaryManagingApplication.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Data
//@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
//    @Id
    private Integer userId;
    private String userName;
    private String password;
    private String mobile;
    private Address address;
    private String email;
}
