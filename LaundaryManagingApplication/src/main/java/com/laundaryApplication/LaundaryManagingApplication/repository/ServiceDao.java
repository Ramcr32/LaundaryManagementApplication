package com.laundaryApplication.LaundaryManagingApplication.repository;

import com.laundaryApplication.LaundaryManagingApplication.model.Admin;
import com.laundaryApplication.LaundaryManagingApplication.model.ServiceBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceDao extends JpaRepository<ServiceBooking,Integer> {
    @Query("from ServiceBooking where ServiceBooking.empId=?")
    public List<ServiceBooking> findAllByEmpId(@Param("empId") Integer empId);

    @Query("from ServiceBooking where ServiceBooking.customerId=?")
    public List<ServiceBooking> findAllByCustomerId(@Param("customerId") Integer customerId);
}
