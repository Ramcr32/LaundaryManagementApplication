package com.laundaryApplication.LaundaryManagingApplication.service.implementsService;

import com.laundaryApplication.LaundaryManagingApplication.exceptions.NotFoundException;
import com.laundaryApplication.LaundaryManagingApplication.model.Employee;
import com.laundaryApplication.LaundaryManagingApplication.repository.EmployeeDao;
import com.laundaryApplication.LaundaryManagingApplication.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmpService {
    @Autowired
    private EmployeeDao eDao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Employee createEmployee(Employee emp) {
        emp.setPassword(passwordEncoder.encode(emp.getPassword()));
        return eDao.save(emp);
    }

    @Override
    public Employee updateEmployee(Employee emp) {
        Employee existingEmp = eDao.findById(emp.getUserId())
                .orElseThrow(()-> new NotFoundException("not found employee with id "+ emp.getUserId()));
        return eDao.save(emp);
    }

    @Override
    public Employee deleteEmployee(Integer empId) {
        Employee existingEmp = eDao.findById(empId)
                .orElseThrow(()-> new NotFoundException("not found employee with id "+ empId));
        eDao.delete(existingEmp);
        return existingEmp;
    }

    @Override
    public List<Employee> getAll() {
        return eDao.findAll();
    }

  @Override
  public boolean findEmployeeById(Integer empId) {
    return eDao.existsById(empId);
  }
}
