package com.laundaryApplication.LaundaryManagingApplication.service;

import com.laundaryApplication.LaundaryManagingApplication.exceptions.NotFoundException;
import com.laundaryApplication.LaundaryManagingApplication.model.Customer;

import java.util.List;

public interface CustomerService {
    public Customer createCustomer(Customer customer) ;
    public Customer updateCustomer(Customer customer) throws NotFoundException;
    public Customer deleteCustomer(Integer customerId) throws NotFoundException;
    public List<Customer> getAll();
    public boolean findCustomerById(Integer customerId);
    public Customer getCustomerById(Integer customerId);

}


