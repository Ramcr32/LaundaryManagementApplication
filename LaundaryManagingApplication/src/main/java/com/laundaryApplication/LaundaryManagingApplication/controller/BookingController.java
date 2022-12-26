package com.laundaryApplication.LaundaryManagingApplication.controller;

import com.laundaryApplication.LaundaryManagingApplication.exceptions.MyErrorDetails;
import com.laundaryApplication.LaundaryManagingApplication.model.ServiceBooking;
import com.laundaryApplication.LaundaryManagingApplication.service.ServiceBookService;
import com.laundaryApplication.LaundaryManagingApplication.util.validators.BookingServiceValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/services")
@CrossOrigin(origins = "http://localhost:4200/")
public class BookingController {
    @Autowired
    private ServiceBookService service;
    @Autowired
    private BookingServiceValidator validator;

    @InitBinder
    public void initBinder(WebDataBinder binder){
      binder.setValidator(validator);
    }
    @PostMapping("/")
    public ResponseEntity<?> createNewServiceHandler(@Valid @RequestBody ServiceBooking ser, Errors errors, WebRequest wr){
        if(errors.hasErrors()){

          MyErrorDetails myErrorDetails = new MyErrorDetails(LocalDateTime.now(), errors.getFieldError().getDefaultMessage(),wr.getDescription(false));
          return new ResponseEntity<>(myErrorDetails,HttpStatus.BAD_REQUEST);
        }
        ServiceBooking sr = service.bookNewService(ser);
        return new ResponseEntity<>(sr, HttpStatus.ACCEPTED);

    }

    @PutMapping("/")
    public ResponseEntity<?> updateServiceHandler(@RequestBody ServiceBooking ser,Errors errors, WebRequest wr){
      if(errors.hasErrors()){

        MyErrorDetails myErrorDetails = new MyErrorDetails(LocalDateTime.now(), errors.getFieldError().getDefaultMessage(),wr.getDescription(false));
        return new ResponseEntity<>(myErrorDetails,HttpStatus.BAD_REQUEST);
      }
        ServiceBooking sr = service.updateService(ser);
        return new ResponseEntity<>(sr, HttpStatus.ACCEPTED);

    }
    @DeleteMapping("/{serviceId}")
    public ResponseEntity<ServiceBooking> deleteServiceHandler(@PathVariable Integer serviceId){
        ServiceBooking sr = service.deleteService(serviceId);
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
