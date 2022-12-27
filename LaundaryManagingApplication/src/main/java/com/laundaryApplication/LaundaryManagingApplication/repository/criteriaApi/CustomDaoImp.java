package com.laundaryApplication.LaundaryManagingApplication.repository.criteriaApi;

import com.laundaryApplication.LaundaryManagingApplication.model.ServiceBooking;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
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

    @Override
    @Transactional
    public ServiceBooking BookingdeleteById(Integer id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaDelete<ServiceBooking> criteriaDelete = cb.createCriteriaDelete(ServiceBooking.class);
        Root<ServiceBooking> serviceBookingRoot = criteriaDelete.from(ServiceBooking.class);
        Predicate p = cb.equal(serviceBookingRoot.get("serviceId"),id);
        criteriaDelete.where(p);
//        ServiceBooking query = (ServiceBooking) entityManager.createQuery(criteriaDelete).getSingleResult();
        entityManager.getTransaction().begin();
        entityManager.createQuery(criteriaDelete).executeUpdate();
        entityManager.getTransaction().commit();
        return  null;
    }
}
