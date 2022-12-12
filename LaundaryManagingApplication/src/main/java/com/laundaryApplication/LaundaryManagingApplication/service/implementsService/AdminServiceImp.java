package com.laundaryApplication.LaundaryManagingApplication.service.implementsService;

import com.laundaryApplication.LaundaryManagingApplication.exceptions.NotFoundException;
import com.laundaryApplication.LaundaryManagingApplication.model.Admin;
import com.laundaryApplication.LaundaryManagingApplication.repository.AdminDao;
import com.laundaryApplication.LaundaryManagingApplication.service.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImp implements AdminService {
    private AdminDao aDao;
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
}
