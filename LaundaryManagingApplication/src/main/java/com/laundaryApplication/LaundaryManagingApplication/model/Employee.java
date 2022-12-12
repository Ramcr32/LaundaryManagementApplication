package com.laundaryApplication.LaundaryManagingApplication.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name="empId")
public class Employee extends User{
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ServiceBooking> serviceBookings;
}
