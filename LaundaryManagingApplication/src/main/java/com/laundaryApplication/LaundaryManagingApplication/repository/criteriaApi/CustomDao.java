package com.laundaryApplication.LaundaryManagingApplication.repository.criteriaApi;

import com.laundaryApplication.LaundaryManagingApplication.model.Customer;
import com.laundaryApplication.LaundaryManagingApplication.model.Employee;
import com.laundaryApplication.LaundaryManagingApplication.model.ServiceBooking;
import com.laundaryApplication.LaundaryManagingApplication.util.Query;

import java.util.List;

public interface CustomDao {

    public List<ServiceBooking> findAllByEmpId(Integer empId);
    public List<ServiceBooking> findAllByCustomerId(Integer customerId);

    public  List<ServiceBooking> findAllBookings();
    public  ServiceBooking BookingdeleteById(Integer id);
    public List<Employee> getAllEmployees(Query query);

}
