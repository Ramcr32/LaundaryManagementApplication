package com.laundaryApplication.LaundaryManagingApplication.service.implementsService;

import com.laundaryApplication.LaundaryManagingApplication.exceptions.NotFoundException;
import com.laundaryApplication.LaundaryManagingApplication.model.ServiceBooking;
import com.laundaryApplication.LaundaryManagingApplication.repository.ServiceDao;
import com.laundaryApplication.LaundaryManagingApplication.repository.criteriaApi.CustomDao;
import com.laundaryApplication.LaundaryManagingApplication.service.ServiceBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceBookServiceImp implements ServiceBookService {
    @Autowired
    private ServiceDao sDao;

    @Autowired
    private CustomDao customDao;
    @Override
    public ServiceBooking bookNewService(ServiceBooking service) {
        return sDao.save(service);
    }

    @Override
    public ServiceBooking updateService(ServiceBooking service) throws NotFoundException {
        ServiceBooking returnService = sDao.findById(service.getServiceId())
                .orElseThrow(()->new NotFoundException("not found service with id"+ service.getServiceId()));
        return sDao.save(service);
    }

    @Override
    public ServiceBooking deleteService(Integer serviceId) throws NotFoundException {
        ServiceBooking returnService = sDao.findById(serviceId)
                .orElseThrow(()->new NotFoundException("not found service with id"+ serviceId));
        customDao.BookingdeleteById(serviceId);
        return returnService;
    }

    @Override
    public List<ServiceBooking> allBookingServices() {
        return customDao.findAllBookings();
    }

    @Override
    public List<ServiceBooking> allServicesOfEmp(Integer empId) {

        List<ServiceBooking> services = customDao.findAllByEmpId(empId);
        return services;
    }

    @Override
    public List<ServiceBooking> allBookingsOfCustomer(Integer customerId) {
        List<ServiceBooking> services = customDao.findAllByCustomerId(customerId);
        return services;
    }
}
