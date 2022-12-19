package com.laundaryApplication.LaundaryManagingApplication.service;

import com.laundaryApplication.LaundaryManagingApplication.model.UserDTO;



public interface SessionService {
    public String logIntoAccount(UserDTO user);

    public String logOutFromAccount(String key);
}
