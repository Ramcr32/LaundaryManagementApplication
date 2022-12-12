package com.laundaryApplication.LaundaryManagingApplication.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    private Integer userId;
    private String userName;
    private String password;
    private String mobile;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id")
    private Address address;
    private String email;
}
