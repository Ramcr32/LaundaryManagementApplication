package com.laundaryApplication.LaundaryManagingApplication.controller;

import com.laundaryApplication.LaundaryManagingApplication.model.Admin;
import com.laundaryApplication.LaundaryManagingApplication.model.Customer;
import com.laundaryApplication.LaundaryManagingApplication.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:4200/")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping("/")
    public ResponseEntity<Customer> createNewCustomerHandler(@RequestBody Customer customer){
        Customer returnCustomer = customerService.createCustomer(customer);
        return  new ResponseEntity<>(returnCustomer, HttpStatus.ACCEPTED);
    }
    @PutMapping("/")
    public  ResponseEntity<Customer> updateCustomerHandler(@RequestBody Customer customer){
        Customer returnCustomer = customerService.updateCustomer(customer);
        return  new ResponseEntity<>(returnCustomer, HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{customerId}")
    public  ResponseEntity<Customer> deleteCustomerHandler(@PathVariable Integer customerId){
        Customer returnCustomer = customerService.deleteCustomer(customerId);
        return  new ResponseEntity<>(returnCustomer, HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<Customer>> deleteAdminHandler(){
        List<Customer> list = customerService.getAll();
        return  new ResponseEntity<>(list, HttpStatus.OK);
    }

}
