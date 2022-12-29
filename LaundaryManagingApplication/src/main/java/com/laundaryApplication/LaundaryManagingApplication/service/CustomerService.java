package com.laundaryApplication.LaundaryManagingApplication.service;

import com.laundaryApplication.LaundaryManagingApplication.exceptions.NotFoundException;
import com.laundaryApplication.LaundaryManagingApplication.model.Customer;
import com.laundaryApplication.LaundaryManagingApplication.util.Query;

import java.util.List;

public interface CustomerService {
    public Customer createCustomer(Customer customer) ;
    public Customer updateCustomer(Customer customer) throws NotFoundException;
    public Customer deleteCustomer(Integer customerId) throws NotFoundException;
    public List<Customer> getAll();
    public List<Customer> getAll(Query query);
    public boolean findCustomerById(Integer customerId);
    public Customer getCustomerById(Integer customerId);

}


