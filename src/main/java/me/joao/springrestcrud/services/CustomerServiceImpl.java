package me.joao.springrestcrud.services;

import me.joao.springrestcrud.dao.CustomerDAO;
import me.joao.springrestcrud.entities.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDAO customerDao;

    public CustomerServiceImpl(CustomerDAO customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDao.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerDao.saveCustomer(customer);
    }

    @Override
    @Transactional
    public Customer getCustomer(Integer id) {
        return customerDao.getCustomer(id);
    }

    @Override
    @Transactional
    public void deleteCustomer(Integer id) {
        customerDao.deleteCustomer(id);
    }

    @Override
    @Transactional
    public List<Customer> searchCustomers(String searchName) {
        return customerDao.searchCustomers(searchName);
    }
}
