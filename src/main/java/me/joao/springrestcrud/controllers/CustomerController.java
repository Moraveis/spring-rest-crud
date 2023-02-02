package me.joao.springrestcrud.controllers;

import me.joao.springrestcrud.entities.Customer;
import me.joao.springrestcrud.exceptions.CustomerNotFoundException;
import me.joao.springrestcrud.services.CustomerService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @PostMapping("/customers")
    public Customer createCostumer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return customer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return customer;
    }

    @DeleteMapping("/customers/{id}")
    public void updateCustomer(@PathVariable("id") Integer id) {
        if (customerService.getCustomer(id) == null) {
            throw new CustomerNotFoundException(String.format("Costumer not found for request id=%s", id));
        }

        customerService.deleteCustomer(id);
    }
}
