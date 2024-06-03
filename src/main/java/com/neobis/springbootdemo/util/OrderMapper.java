package com.neobis.springbootdemo.util;
import com.neobis.springbootdemo.dto.OrderDTO;
import com.neobis.springbootdemo.entity.Order;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {
    public static OrderDTO toDTO(Order order) {
        if (order == null) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId(order.getOrderId());
        orderDTO.setCustomerId(order.getCustomerId());
        orderDTO.setOrderDate(order.getOrderDate());
        orderDTO.setTotalAmount(order.getTotalAmount());

        return orderDTO;
    }

    public static Order toEntity(OrderDTO orderDTO) {
        if (orderDTO == null) {
            return null;
        }

        Order order = new Order();
        order.setOrderId(orderDTO.getOrderId());
        order.setCustomerId(orderDTO.getCustomerId());
        order.setOrderDate(orderDTO.getOrderDate());
        order.setTotalAmount(orderDTO.getTotalAmount());

        return order;
    }

    public static List<OrderDTO> toDTOList(List<Order> orders) {
        if (orders == null) {
            return null;
        }
        return orders.stream()
                .map(OrderMapper::toDTO)
                .collect(Collectors.toList());


    }

    public static List<Order> toEntityList(List<OrderDTO> orderDTOs) {
        if (orderDTOs == null) {
            return null;
        }
        return orderDTOs.stream()
                .map(OrderMapper::toEntity)
                .collect(Collectors.toList());
    }
}
