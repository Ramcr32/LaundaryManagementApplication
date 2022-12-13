package com.laundaryApplication.LaundaryManagingApplication.controller;

import com.laundaryApplication.LaundaryManagingApplication.model.Admin;
import com.laundaryApplication.LaundaryManagingApplication.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200/")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @PostMapping("/")
    public ResponseEntity<Admin> createNewAdminHandler(@RequestBody Admin admin){
        Admin returnAdmin =adminService.createAdmin(admin);
        return new ResponseEntity<>(returnAdmin, HttpStatus.ACCEPTED );
    }
    @PutMapping("/")
    public ResponseEntity<Admin> updateAdminHandler(@RequestBody Admin admin){
        Admin returnAdmin = adminService.updateAdmin(admin);
        return  new ResponseEntity<>(returnAdmin ,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{adminId}")
    public ResponseEntity<Admin> deleteAdminHandler(@PathVariable Integer adminId){
        Admin returnAdmin = adminService.deleteAdmin(adminId);
        return  new ResponseEntity<>(returnAdmin, HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<Admin>> deleteAdminHandler(){
        List<Admin> list = adminService.getAll();
        return  new ResponseEntity<>(list, HttpStatus.OK);
    }

}
