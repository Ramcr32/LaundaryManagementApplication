package com.laundaryApplication.LaundaryManagingApplication.repository;

import com.laundaryApplication.LaundaryManagingApplication.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminDao extends JpaRepository<Admin,Integer> {
    public Optional<Admin> findByEmail(String email);
}
