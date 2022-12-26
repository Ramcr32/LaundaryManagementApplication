package com.laundaryApplication.LaundaryManagingApplication.repository.criteriaApi;

import com.laundaryApplication.LaundaryManagingApplication.model.ServiceBooking;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CustomDaoImp implements  CustomDao{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<ServiceBooking> findAllByEmpId(Integer empId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ServiceBooking> cq = cb.createQuery(ServiceBooking.class);
        Root<ServiceBooking> serviceBookingRoot = cq.from(ServiceBooking.class);
        Predicate empIdPredicate = cb.equal(serviceBookingRoot.get("empId"),empId);
        cq.where(empIdPredicate);
        TypedQuery<ServiceBooking> query= entityManager.createQuery(cq);

        return query.getResultList();
    }

    @Override
    public List<ServiceBooking> findAllByCustomerId(Integer customerId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ServiceBooking> cq = cb.createQuery(ServiceBooking.class);
        Root<ServiceBooking> serviceBookingRoot = cq.from(ServiceBooking.class);
        Predicate empIdPredicate = cb.equal(serviceBookingRoot.get("customerId"),customerId);
        cq.where(empIdPredicate);
        TypedQuery<ServiceBooking> query= entityManager.createQuery(cq);

        return query.getResultList();
    }

    @Override
    public List<ServiceBooking> findAllBookings() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ServiceBooking> cq = cb.createQuery(ServiceBooking.class);
        Root<ServiceBooking> serviceBookingRoot = cq.from(ServiceBooking.class);
        TypedQuery<ServiceBooking> query = entityManager.createQuery(cq);
        return query.getResultList();
    }
}
