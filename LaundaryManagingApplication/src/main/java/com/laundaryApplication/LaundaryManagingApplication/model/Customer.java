package com.laundaryApplication.LaundaryManagingApplication.model;

import javax.persistence.PrimaryKeyJoinColumn;

@PrimaryKeyJoinColumn(name="customerId")
public class Customer extends User{
}
