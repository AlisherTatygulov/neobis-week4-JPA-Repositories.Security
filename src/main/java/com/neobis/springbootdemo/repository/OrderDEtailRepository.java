package com.neobis.springbootdemo.repository;

import com.neobis.springbootdemo.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDEtailRepository extends JpaRepository <OrderDetail, Long> {
}
