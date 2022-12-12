package com.laundaryApplication.LaundaryManagingApplication.service;

import com.laundaryApplication.LaundaryManagingApplication.model.Employee;

public interface EmpService {
    public Employee createEmployee(Employee emp);
    public Employee updateEmployee(Employee emp);
    public Employee deleteEmployee(Integer empId);
}
