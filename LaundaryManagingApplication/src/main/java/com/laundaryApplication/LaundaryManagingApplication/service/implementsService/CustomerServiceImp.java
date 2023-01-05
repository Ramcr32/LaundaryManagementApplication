package com.laundaryApplication.LaundaryManagingApplication.service.implementsService;

import com.laundaryApplication.LaundaryManagingApplication.exceptions.NotFoundException;
import com.laundaryApplication.LaundaryManagingApplication.model.Customer;
import com.laundaryApplication.LaundaryManagingApplication.repository.CustomerDao;
import com.laundaryApplication.LaundaryManagingApplication.repository.criteriaApi.CustomDao;
import com.laundaryApplication.LaundaryManagingApplication.service.CustomerService;
import com.laundaryApplication.LaundaryManagingApplication.util.Page;
import com.laundaryApplication.LaundaryManagingApplication.util.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    private CustomerDao cDao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CustomDao customDao;
    @Override
    public Customer createCustomer(Customer customer) {
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return cDao.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) throws NotFoundException {
        Customer c = cDao.findById(customer.getUserId())
                .orElseThrow(()-> new NotFoundException("customer is not present"));
        return cDao.save(customer);
    }

    @Override
    public Customer deleteCustomer(Integer customerId) throws NotFoundException {
        Customer customer = cDao.findById(customerId)
                            .orElseThrow(()-> new NotFoundException("customer is not present"));
        cDao.delete(customer);
        return customer;
    }

    @Override
    public List<Customer> getAll() {
        return cDao.findAll();
    }

    @Override
    public Page getAll(Query query) {
        return customDao.getAllCustomers(query);
    }

    @Override
    public boolean findCustomerById(Integer customerId) {
        return cDao.existsById(customerId);
    }

    @Override
    public Customer getCustomerById(Integer customerId) {
        Customer customer= cDao.findById(customerId)
                .orElseThrow(()->new NotFoundException("customer is not found"));
        return customer;
    }
}
