package com.laundaryApplication.LaundaryManagingApplication.service;

import com.laundaryApplication.LaundaryManagingApplication.exceptions.NotFoundException;
import com.laundaryApplication.LaundaryManagingApplication.model.Customer;

public interface CustomerService {
    public Customer createCustomer(Customer customer) ;
    public Customer updateCustomer(Customer customer) throws NotFoundException;
    public Customer deleteCustomer(Integer customerId) throws NotFoundException;

    public boolean findCustomerById(Integer customerId);

}


