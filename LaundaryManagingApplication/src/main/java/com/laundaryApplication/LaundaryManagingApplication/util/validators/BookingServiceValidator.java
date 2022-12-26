package com.laundaryApplication.LaundaryManagingApplication.util.validators;

import com.laundaryApplication.LaundaryManagingApplication.controller.BookingController;
import com.laundaryApplication.LaundaryManagingApplication.model.ServiceBooking;
import com.laundaryApplication.LaundaryManagingApplication.service.CustomerService;
import com.laundaryApplication.LaundaryManagingApplication.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.LocalDate;

@ControllerAdvice(assignableTypes = BookingController.class)
public class BookingServiceValidator implements Validator {

    @Autowired
    private EmpService empService;
    @Autowired
    private CustomerService customerService;
    @Override
    public boolean supports(Class<?> clazz) {
        return ServiceBooking.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "customerId","customer id is required" );
        ValidationUtils.rejectIfEmpty(errors,"empId","employee id is must required");
        ServiceBooking service = (ServiceBooking) target;
        if(service.getPiece()<=0){

          errors.rejectValue("piece","500","piece should be grater than zero");
        }
        else if(LocalDate.now().compareTo(service.getBookingDate())>0){
          errors.rejectValue("bookingDate" , "500" , "date should be today and future date");
        }
        else if(!empService.findEmployeeById(service.getEmpId())){
            errors.rejectValue("empId","500","emp is not exist");
        }
        else if(!customerService.findCustomerById(service.getCustomerId())){
            errors.rejectValue("customerId","500","customer is not exist");
        }


    }
}
