package com.laundaryApplication.LaundaryManagingApplication.repository.criteriaApi;

import com.laundaryApplication.LaundaryManagingApplication.model.ServiceBooking;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomDao {

    public List<ServiceBooking> findAllByEmpId(Integer empId);
    public List<ServiceBooking> findAllByCustomerId(Integer customerId);

    public  List<ServiceBooking> findAllBookings();

}
