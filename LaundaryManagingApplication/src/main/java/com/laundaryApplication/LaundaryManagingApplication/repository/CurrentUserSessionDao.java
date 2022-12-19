package com.laundaryApplication.LaundaryManagingApplication.repository;

import com.laundaryApplication.LaundaryManagingApplication.model.CurrentUserSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurrentUserSessionDao extends JpaRepository<CurrentUserSession,Integer> {
    public Optional<CurrentUserSession> findById(Integer userId);

    public Optional<CurrentUserSession> findByUuid(String uuid);
    public Optional<CurrentUserSession> findByEmail(String email);
}
