package com.laundaryApplication.LaundaryManagingApplication.security;

import com.laundaryApplication.LaundaryManagingApplication.model.Admin;
import com.laundaryApplication.LaundaryManagingApplication.model.User;
import com.laundaryApplication.LaundaryManagingApplication.repository.AdminDao;
import com.laundaryApplication.LaundaryManagingApplication.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserService implements UserDetailsService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private AdminDao adminDao;
    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
//        Admin admin = adminDao.findByEmail(userEmail).get();
            User user = userDao.findByEmail(userEmail);
        return  user;
    }
}
