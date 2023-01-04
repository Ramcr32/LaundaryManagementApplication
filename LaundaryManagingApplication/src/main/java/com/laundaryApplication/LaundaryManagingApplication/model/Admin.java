package com.laundaryApplication.LaundaryManagingApplication.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@PrimaryKeyJoinColumn(name = "adminId")
public class Admin extends  User  {

}
