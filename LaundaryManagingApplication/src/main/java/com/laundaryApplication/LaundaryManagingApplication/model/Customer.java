package com.laundaryApplication.LaundaryManagingApplication.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.List;
@Entity
@PrimaryKeyJoinColumn(name="customerId")
public class Customer extends User{
    @OneToMany(cascade = CascadeType.ALL)
    private List<ServiceBooking> serviceBookings;
}
