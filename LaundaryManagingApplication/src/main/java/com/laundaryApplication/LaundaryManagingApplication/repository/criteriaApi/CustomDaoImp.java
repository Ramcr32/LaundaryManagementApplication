package com.laundaryApplication.LaundaryManagingApplication.repository.criteriaApi;

import com.laundaryApplication.LaundaryManagingApplication.model.Customer;
import com.laundaryApplication.LaundaryManagingApplication.model.Employee;
import com.laundaryApplication.LaundaryManagingApplication.model.ServiceBooking;
import com.laundaryApplication.LaundaryManagingApplication.util.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
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
    public Integer BookingdeleteById(Integer id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaDelete<ServiceBooking> criteriaDelete = cb.createCriteriaDelete(ServiceBooking.class);
        Root<ServiceBooking> serviceBookingRoot = criteriaDelete.from(ServiceBooking.class);
        Predicate p = cb.equal(serviceBookingRoot.get("serviceId"),id);
        criteriaDelete.where(p);
//        ServiceBooking query = (ServiceBooking) entityManager.createQuery(criteriaDelete).getSingleResult();



        return  entityManager.createQuery(criteriaDelete).executeUpdate();
    }

    @Override
    public List<Employee> getAllEmployees(Query query) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = cb.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);
        Predicate p = cb.equal(employeeRoot.get(query.getTitle()),query.getSearchQuery());
        criteriaQuery.where(p);
        criteriaQuery.orderBy(cb.asc(employeeRoot.get(query.getSorting())));
        TypedQuery<Employee> typedQuery = entityManager.createQuery(criteriaQuery);
        return  typedQuery.getResultList();
    }
}
