package com.neobis.springbootdemo.sevice;

import com.neobis.springbootdemo.dto.CustomerDTO;
import com.neobis.springbootdemo.repository.CustomerRepository;
import com.neobis.springbootdemo.entity.Customer;
import com.neobis.springbootdemo.util.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{


    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> findAll() {

        List<CustomerDTO> customersDTO = CustomerMapper.toDTOList(customerRepository.findAll());
        return customersDTO;
    }

    @Override
    public CustomerDTO findById(long theId) {
        Optional<Customer> data = customerRepository.findById(theId);
        Customer theCustomer = null;

        if (data.isPresent()) {
            theCustomer = data.get();
        }
        else {
            throw new RuntimeException("Did not find customer ID " + theId);
        }
        return CustomerMapper.toDTO(theCustomer);
    }

    @Override
    public CustomerDTO save(Customer theCustomer) {

        Customer customer = customerRepository.save(theCustomer);
        return CustomerMapper.toDTO(customer);
    }

    @Override
    public void deleteById(long theId) {
        customerRepository.deleteById(theId);
    }
}
