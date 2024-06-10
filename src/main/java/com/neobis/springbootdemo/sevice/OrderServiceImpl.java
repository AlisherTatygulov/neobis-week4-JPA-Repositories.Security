package com.neobis.springbootdemo.sevice;

import com.neobis.springbootdemo.dto.OrderDTO;
import com.neobis.springbootdemo.entity.Order;
import com.neobis.springbootdemo.repository.OrderRepository;
import com.neobis.springbootdemo.util.OrderMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @Override
    public List<OrderDTO> findAll() {
        List<OrderDTO> orders = OrderMapper.toDTOList(orderRepository.findAll());
        return orders;
    }

    @Override
    public OrderDTO findById(long theId) {

        Optional<Order> data = orderRepository.findById(theId);
        Order theOrder = null;

        if (data.isPresent()) {
            theOrder = data.get();
        }
        else {
            throw new RuntimeException("Did not find order ID " + theId);
        }
        return OrderMapper.toDTO(theOrder);
    }

    @Override
    public OrderDTO save(Order theOrder) {

        Order order = orderRepository.save(theOrder);
        return OrderMapper.toDTO(order);

    }

    @Override
    public void deleteById(long theId) {
        orderRepository.deleteById(theId);
    }
}
