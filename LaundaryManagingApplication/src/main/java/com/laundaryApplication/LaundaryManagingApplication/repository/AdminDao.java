package com.laundaryApplication.LaundaryManagingApplication.repository;

import com.laundaryApplication.LaundaryManagingApplication.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao extends JpaRepository<Admin,Integer> {
}
