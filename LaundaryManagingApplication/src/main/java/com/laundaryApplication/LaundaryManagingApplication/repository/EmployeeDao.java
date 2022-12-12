package com.laundaryApplication.LaundaryManagingApplication.repository;

import com.laundaryApplication.LaundaryManagingApplication.model.Admin;
import com.laundaryApplication.LaundaryManagingApplication.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<Employee,Integer> {
}
