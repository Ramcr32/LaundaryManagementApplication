package com.laundaryApplication.LaundaryManagingApplication.util.validators;

import com.laundaryApplication.LaundaryManagingApplication.controller.AdminController;
import com.laundaryApplication.LaundaryManagingApplication.model.Admin;
import com.laundaryApplication.LaundaryManagingApplication.model.User;
import com.laundaryApplication.LaundaryManagingApplication.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice(assignableTypes = AdminController.class)
public class UserValidator implements Validator {
    @Autowired
    private AdminService adminService;
    @Override
    public boolean supports(Class<?> clazz) {
        return Admin.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "email","500","email is required" );
        Admin admin = (Admin) target;
        if(adminService.checkUserByEmail(admin.getEmail())){
            errors.rejectValue("email","500" ,"Account is already exist");
        }
    }
}
