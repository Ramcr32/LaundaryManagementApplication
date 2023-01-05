package com.laundaryApplication.LaundaryManagingApplication.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Collection;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    private String userName;
    @Size(min = 4 , message = "please give valid pasword")
    private String password;
    @Size(min=10, message = "please give valid mobile number")
    private String mobile;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="id")
    private Address address;
    @Email(message = "please give valid email")
    private String email;


}
