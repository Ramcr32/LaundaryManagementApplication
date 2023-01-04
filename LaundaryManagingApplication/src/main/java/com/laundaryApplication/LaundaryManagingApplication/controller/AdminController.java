package com.laundaryApplication.LaundaryManagingApplication.controller;

import com.laundaryApplication.LaundaryManagingApplication.exceptions.MyErrorDetails;
import com.laundaryApplication.LaundaryManagingApplication.model.Admin;
import com.laundaryApplication.LaundaryManagingApplication.model.UserDTO;
import com.laundaryApplication.LaundaryManagingApplication.service.AdminService;
import com.laundaryApplication.LaundaryManagingApplication.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200/")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private SessionService sessionService;
    @PostMapping("/")
    public ResponseEntity<Admin> createNewAdminHandler(@RequestBody Admin admin){
        Admin returnAdmin =adminService.createAdmin(admin);
        return new ResponseEntity<>(returnAdmin, HttpStatus.ACCEPTED );
    }
    @PutMapping("/")
    public ResponseEntity<Admin> updateAdminHandler(@RequestBody Admin admin){
        Admin returnAdmin = adminService.updateAdmin(admin);
        return  new ResponseEntity<>(returnAdmin ,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{adminId}")
    public ResponseEntity<Admin> deleteAdminHandler(@PathVariable Integer adminId){
        Admin returnAdmin = adminService.deleteAdmin(adminId);
        return  new ResponseEntity<>(returnAdmin, HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<Admin>> deleteAdminHandler(){
        List<Admin> list = adminService.getAll();
        return  new ResponseEntity<>(list, HttpStatus.OK);
    }
    //for admin login
    @PostMapping(value = "a/login")
    public ResponseEntity<MyErrorDetails> logInCustomer(@Valid @RequestBody UserDTO user,Error error) {
        String message = sessionService.logIntoAccount(user);
        MyErrorDetails me = new MyErrorDetails(LocalDateTime.now(),message, error.getMessage());
        return new ResponseEntity<>(me,HttpStatus.ACCEPTED);
    }

    // for admin Logout
    @PatchMapping(value = "a/logout")
    public ResponseEntity<MyErrorDetails> logOutCustomer(@RequestParam(required = false) String key,Error error) {
        String message = sessionService.logOutFromAccount(key);
        MyErrorDetails me = new MyErrorDetails(LocalDateTime.now(),message, error.getMessage());
        return new ResponseEntity<>(me,HttpStatus.ACCEPTED);
    }


}
