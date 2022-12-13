package com.laundaryApplication.LaundaryManagingApplication.service;

import com.laundaryApplication.LaundaryManagingApplication.exceptions.NotFoundException;
import com.laundaryApplication.LaundaryManagingApplication.model.ServiceBooking;

import java.util.List;

public interface ServiceBookService {
    public ServiceBooking bookNewService(ServiceBooking  service) ;
    public ServiceBooking updateService(ServiceBooking service) throws NotFoundException;
    public ServiceBooking deleteService(Integer serviceId) throws NotFoundException;
    public List<ServiceBooking> allBookingServices();
    public List<ServiceBooking> allServicesOfEmp(Integer empId) throws NotFoundException;
    public List<ServiceBooking> allBookingsOfCustomer(Integer customerId) throws  NotFoundException;


}
