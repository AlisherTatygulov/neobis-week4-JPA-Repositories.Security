package com.neobis.springbootdemo.sevice;

import com.neobis.springbootdemo.dto.CustomerDTO;
import com.neobis.springbootdemo.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> findAll();

    CustomerDTO findById(long theId);

    CustomerDTO save(Customer theEmployee);

    void deleteById(long theId);

}
