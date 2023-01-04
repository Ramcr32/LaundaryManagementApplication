package com.laundaryApplication.LaundaryManagingApplication.service.implementsService;

import com.laundaryApplication.LaundaryManagingApplication.exceptions.NotFoundException;
import com.laundaryApplication.LaundaryManagingApplication.model.Admin;
import com.laundaryApplication.LaundaryManagingApplication.repository.AdminDao;
import com.laundaryApplication.LaundaryManagingApplication.repository.criteriaApi.CustomDao;
import com.laundaryApplication.LaundaryManagingApplication.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImp implements AdminService {
    @Autowired
    private AdminDao aDao;
    @Autowired
    private CustomDao customDao;
    @Override
    public Admin createAdmin(Admin admin) {

        return aDao.save(admin);
    }

    @Override
    public Admin updateAdmin(Admin admin) throws NotFoundException {
        Admin existingAdmin = aDao.findById(admin.getUserId())
                .orElseThrow(()->new NotFoundException("admin is not found with id "+ admin.getUserId()));

        return aDao.save(admin);
    }

    @Override
    public Admin deleteAdmin(Integer adminId) throws NotFoundException {
        Admin existingAdmin = aDao.findById(adminId)
                .orElseThrow(()->new NotFoundException("admin is not found with id " + adminId));
        aDao.delete(existingAdmin);
        return existingAdmin;
    }

    @Override
    public List<Admin> getAll() {
        return aDao.findAll();
    }
}
