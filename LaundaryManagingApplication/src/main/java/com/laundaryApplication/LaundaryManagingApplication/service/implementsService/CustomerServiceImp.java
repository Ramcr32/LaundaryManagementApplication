package com.laundaryApplication.LaundaryManagingApplication.service.implementsService;

import com.laundaryApplication.LaundaryManagingApplication.exceptions.NotFoundException;
import com.laundaryApplication.LaundaryManagingApplication.model.Customer;
import com.laundaryApplication.LaundaryManagingApplication.repository.CustomerDao;
import com.laundaryApplication.LaundaryManagingApplication.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImp implements CustomerService {
    private CustomerDao cDao;
    @Override
    public Customer createCustomer(Customer customer) {
        return cDao.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) throws NotFoundException {
        return null;
    }

    @Override
    public Customer deleteCustomer(Integer customerId) throws NotFoundException {
        return null;
    }
}
