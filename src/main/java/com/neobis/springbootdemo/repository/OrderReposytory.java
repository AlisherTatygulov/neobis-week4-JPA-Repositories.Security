package com.neobis.springbootdemo.repository;

import com.neobis.springbootdemo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderReposytory extends JpaRepository<Order, Long> {
}
