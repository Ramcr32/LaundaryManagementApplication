package com.laundaryApplication.LaundaryManagingApplication.service.implementsService;

import com.laundaryApplication.LaundaryManagingApplication.exceptions.NotFoundException;
import com.laundaryApplication.LaundaryManagingApplication.model.Admin;
import com.laundaryApplication.LaundaryManagingApplication.model.CurrentUserSession;
import com.laundaryApplication.LaundaryManagingApplication.model.UserDTO;
import com.laundaryApplication.LaundaryManagingApplication.repository.AdminDao;
import com.laundaryApplication.LaundaryManagingApplication.repository.CurrentUserSessionDao;
import com.laundaryApplication.LaundaryManagingApplication.service.SessionService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.channels.AlreadyConnectedException;
import java.time.LocalDateTime;
import java.util.Optional;
@Service
public class SessionServiceImp implements  SessionService {
    @Autowired
    private CurrentUserSessionDao currentUserSessionDao;
    @Autowired
    private AdminDao adminDao;



    @Override
    public String logIntoAccount(UserDTO user) {
        Optional<Admin> opt = adminDao.findByEmail(user.getEmail());
        if(!opt.isPresent()){
            throw new NotFoundException("admin is not found ");
        }
        Optional<CurrentUserSession> opt1 = currentUserSessionDao.findById(opt.get().getUserId());
        if(opt1.isPresent()){
            throw  new AlreadyConnectedException();
        }
        if(user.getPassword().equals(opt.get().getPassword())){
            String key = RandomString.make(6);
            CurrentUserSession cObject = new CurrentUserSession(opt.get().getUserId(),opt.get().getEmail(),key, LocalDateTime.now());
            currentUserSessionDao.save(cObject);
        }
        else {
            throw  new NotFoundException("may be wrong password");
        }
        return "login successfull";
    }

    @Override
    public String logOutFromAccount(String key) {
       Optional<CurrentUserSession> session =  currentUserSessionDao.findByUuid(key);
       if(session.isPresent()){
           currentUserSessionDao.delete(session.get());
       }
       else{

       }
       return " log out ...";
    }
}
