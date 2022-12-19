package com.laundaryApplication.LaundaryManagingApplication.util.validators;

import com.laundaryApplication.LaundaryManagingApplication.model.ServiceBooking;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class BookingServiceValidator implements Validator {
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
            throw new IllegalArgumentException("give valid value of piece");
        }


    }
}
