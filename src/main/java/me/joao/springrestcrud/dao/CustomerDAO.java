package me.joao.springrestcrud.dao;

import me.joao.springrestcrud.entities.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(Integer id);

    void deleteCustomer(Integer id);

    List<Customer> searchCustomers(String searchName);

}
