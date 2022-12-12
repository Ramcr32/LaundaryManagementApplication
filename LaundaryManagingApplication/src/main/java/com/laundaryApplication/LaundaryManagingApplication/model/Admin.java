package com.laundaryApplication.LaundaryManagingApplication.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
@Data
@Entity
@PrimaryKeyJoinColumn(name = "adminId")
public class Admin extends  User {
}
