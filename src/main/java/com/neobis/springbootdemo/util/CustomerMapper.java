package com.neobis.springbootdemo.util;

import com.neobis.springbootdemo.dto.CustomerDTO;
import com.neobis.springbootdemo.entity.Customer;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerMapper {

    public static CustomerDTO toDTO(Customer customer) {
        if (customer == null) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerId(customer.getCustomerId());
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setAddress(customer.getAddress());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPhoneNumber(customer.getPhoneNumber());

        return customerDTO;
    }

    public static Customer toEntity(CustomerDTO customerDTO) {
        if (customerDTO == null) {
            return null;
        }

        Customer customer = new Customer();
        customer.setCustomerId(customerDTO.getCustomerId());
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setAddress(customerDTO.getAddress());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());

        return customer;
    }

    public static List<CustomerDTO> toDTOList(List<Customer> customers) {
        if (customers == null) {
            return null;
        }

        return customers.stream()
                .map(CustomerMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Метод для преобразования List<CustomerDTO> в List<Customer>
    public static List<Customer> toEntityList(List<CustomerDTO> customerDTOs) {
        if (customerDTOs == null) {
            return null;
        }

        return customerDTOs.stream()
                .map(CustomerMapper::toEntity)
                .collect(Collectors.toList());
    }
}
