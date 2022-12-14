package com.laundaryApplication.LaundaryManagingApplication.service;

import com.laundaryApplication.LaundaryManagingApplication.model.Employee;

import java.util.List;

public interface EmpService {
    public Employee createEmployee(Employee emp);
    public Employee updateEmployee(Employee emp);
    public Employee deleteEmployee(Integer empId);
    public List<Employee> getAll();
}
