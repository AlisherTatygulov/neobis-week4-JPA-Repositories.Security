package com.neobis.springbootdemo.repository;

import com.neobis.springbootdemo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
