package com.laundaryApplication.LaundaryManagingApplication.controller;

import com.laundaryApplication.LaundaryManagingApplication.model.ServiceBooking;
import com.laundaryApplication.LaundaryManagingApplication.service.ServiceBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
@CrossOrigin(origins = "http://localhost:4200/")
public class BookingController {
    @Autowired
    private ServiceBookService service;

    @PostMapping("/")
    public ResponseEntity<ServiceBooking> createNewServiceHandler(@RequestBody ServiceBooking ser){
        ServiceBooking sr = service.bookNewService(ser);
        return new ResponseEntity<>(sr, HttpStatus.ACCEPTED);

    }

    @PutMapping("/")
    public ResponseEntity<ServiceBooking> updateServiceHandler(@RequestBody ServiceBooking ser){
        ServiceBooking sr = service.updateService(ser);
        return new ResponseEntity<>(sr, HttpStatus.ACCEPTED);

    }
    @DeleteMapping("/{serviceId}")
    public ResponseEntity<ServiceBooking> deleteServiceHandler(@PathVariable Integer serviceid){
        ServiceBooking sr = service.deleteService(serviceid);
        return new ResponseEntity<>(sr, HttpStatus.OK);

    }
    @GetMapping("/")
    public ResponseEntity<List<ServiceBooking> > getAllServicesHandler(){
        List<ServiceBooking> services = service.allBookingServices();
        return new ResponseEntity<>(services, HttpStatus.FOUND);
    }
    @GetMapping("/emps/{empId}")
    public ResponseEntity<List<ServiceBooking> > getAllServicesByEmpIdHandler(@PathVariable Integer empId){
        List<ServiceBooking> services = service.allServicesOfEmp(empId);
        return new ResponseEntity<>(services, HttpStatus.FOUND);
    }
    @GetMapping("/customers/{customerId}")
    public ResponseEntity<List<ServiceBooking> > getAllServicesByCustomerIdHandler(@PathVariable Integer customerId){
        List<ServiceBooking> services = service.allServicesOfEmp(customerId);
        return new ResponseEntity<>(services, HttpStatus.FOUND);
    }

}
