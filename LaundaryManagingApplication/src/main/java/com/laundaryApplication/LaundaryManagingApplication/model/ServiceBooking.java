package com.laundaryApplication.LaundaryManagingApplication.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
@Entity
@Data

public class ServiceBooking {
    @Id
    private Integer serviceId;
    private Integer customerId;
    private  Integer empId;
    private LocalDate bookingDate;
    private Integer price;
}
