package com.laundaryApplication.LaundaryManagingApplication.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Entity
@Data

public class ServiceBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer serviceId;
    @NotNull
    private Integer customerId;
    @NotNull
    private  Integer empId;
    @NotNull
    private LocalDate bookingDate;
    @NotNull
    private Integer piece;
    private Integer price;
//    ServiceBooking(Integer piece){
//        this.piece=piece;
//        this.price=piece*10;
//    }
}
