package com.laundaryApplication.LaundaryManagingApplication.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    private String userName;
    @Size(min = 4 , max = 12, message = "please give valid pasword")
    private String password;
    @Size(min=10, message = "please give valid mobile number")
    private String mobile;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id")
    private Address address;
    @Email(message = "please give valid email")
    private String email;
}
