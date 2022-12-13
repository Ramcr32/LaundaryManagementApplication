package com.laundaryApplication.LaundaryManagingApplication.controller;

import com.laundaryApplication.LaundaryManagingApplication.model.Employee;
import com.laundaryApplication.LaundaryManagingApplication.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Employee")
@CrossOrigin(origins = "http://localhost:4200/")
public class EmployeeController {
    @Autowired
    private EmpService empService;

    @PostMapping("/")
    public ResponseEntity<Employee> createNewEmpHandler(@RequestBody Employee emp){
        Employee employee = empService.createEmployee(emp);
        return  new ResponseEntity<>(employee, HttpStatus.ACCEPTED);

    }
    @PutMapping("/")
    public ResponseEntity<Employee> updateEmpHandler(@RequestBody Employee emp){
        Employee employee = empService.updateEmployee(emp);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
    @DeleteMapping("/{empId}")
    public ResponseEntity<Employee> updateEmpHandler(@PathVariable Integer empId){
        Employee employee = empService.deleteEmployee(empId);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

}
