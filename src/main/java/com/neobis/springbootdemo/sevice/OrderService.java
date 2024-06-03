package com.neobis.springbootdemo.sevice;

import com.neobis.springbootdemo.dto.OrderDTO;
import com.neobis.springbootdemo.entity.Customer;
import com.neobis.springbootdemo.entity.Order;
import com.neobis.springbootdemo.repository.OrderRepository;

import java.util.List;

public interface OrderService {

    List<OrderDTO> findAll();

    OrderDTO findById(long theId);

    OrderDTO save(Order theOrder);

    void deleteById(long theId);
}
