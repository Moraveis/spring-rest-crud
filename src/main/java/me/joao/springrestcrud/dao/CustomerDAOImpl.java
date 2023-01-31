package me.joao.springrestcrud.dao;

import me.joao.springrestcrud.entities.Customer;
import org.apache.logging.log4j.util.Strings;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@Repository
@EnableTransactionManagement
public class CustomerDAOImpl implements CustomerDAO {
    private final SessionFactory sessionFactory;

    public CustomerDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Customer> getCustomers() {
        Session session = sessionFactory.getCurrentSession();

        Query<Customer> findAllQuery = session.createQuery("from Customer order by lastName", Customer.class);

        return findAllQuery.getResultList();
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class, id);
    }

    @Override
    public void deleteCustomer(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, id);
        session.delete(customer);
    }

    @Override
    public List<Customer> searchCustomers(String searchName) {
        Session session = sessionFactory.getCurrentSession();

        Query<Customer> query;
        if (!Strings.isEmpty(searchName.trim())) {
            query = session.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
            query.setParameter("theName", "%" + searchName.toLowerCase() + "%");
        } else {
            query = session.createQuery("from Customer", Customer.class);
        }

        return query.getResultList();
    }
}
