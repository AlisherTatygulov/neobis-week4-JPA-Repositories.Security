package com.neobis.springbootdemo.controller;

import com.neobis.springbootdemo.dto.CustomerDTO;
import com.neobis.springbootdemo.entity.Customer;
import com.neobis.springbootdemo.sevice.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {


    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        return customerService.findAll();
    }

    @GetMapping("/{customerId}")
    public CustomerDTO getCustomerById(@PathVariable Long customerId) {

        CustomerDTO theCustomer = customerService.findById(customerId);

        if (theCustomer == null) {
            throw new RuntimeException("Customer not found " + customerId);
        }
        return theCustomer;
    }

    @PostMapping
    public CustomerDTO addCustomer(@RequestBody Customer theCustomer) {

        theCustomer.setCustomerId(0L);

        CustomerDTO dbCustomer = customerService.save(theCustomer);

        return dbCustomer;
    }

    @PutMapping
    public CustomerDTO updateCustomer(@RequestBody Customer theCustomer) {

        CustomerDTO dbCustomer = customerService.save(theCustomer);
        return dbCustomer;
    }

    @DeleteMapping("/{customerId}")
    public String deleteCustomerById(@PathVariable Long customerId) {

        CustomerDTO tempCustomer = customerService.findById(customerId);

        if (tempCustomer == null) {
            throw new RuntimeException("Customer with id " + customerId + " NOT FOUND!");
        }

        customerService.deleteById(customerId);
        return "Customer with id " + customerId + " was deleted";
    }
}
