package me.joao.springrestcrud.controllers;

import me.joao.springrestcrud.entities.Customer;
import me.joao.springrestcrud.exceptions.CustomerNotFoundException;
import me.joao.springrestcrud.services.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable("id") Integer id) {

        Customer customer = customerService.getCustomer(id);

        if (customer == null) {
            throw new CustomerNotFoundException(String.format("Customer with id=%s not found.", id));
        }

        return customer;
    }
}
