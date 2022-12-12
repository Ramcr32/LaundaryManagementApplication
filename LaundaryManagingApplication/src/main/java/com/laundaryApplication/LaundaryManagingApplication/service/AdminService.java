package com.laundaryApplication.LaundaryManagingApplication.service;

import com.laundaryApplication.LaundaryManagingApplication.exceptions.NotFoundException;
import com.laundaryApplication.LaundaryManagingApplication.model.Admin;

public interface AdminService {
    public Admin createAdmin(Admin admin) ;
    public Admin updateAdmin(Admin admin) throws NotFoundException;
    public Admin deleteAdmin(Integer adminId) throws NotFoundException;

}
