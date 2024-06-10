package com.neobis.springbootdemo.util;

import com.neobis.springbootdemo.dto.OrderDetailDTO;
import com.neobis.springbootdemo.entity.OrderDetail;

import java.util.List;
import java.util.stream.Collectors;

public class OrderDetailMapper {

    public static OrderDetailDTO toDTO(OrderDetail orderDetail) {
        if (orderDetail == null) {
            return null;
        }

        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
        orderDetailDTO.setDetailId(orderDetail.getDetailId());
        orderDetailDTO.setOrderId(orderDetail.getOrderId());
        orderDetailDTO.setBookId(orderDetail.getBookId());
        orderDetailDTO.setQuantity(orderDetail.getQuantity());
        orderDetailDTO.setPrice(orderDetail.getPrice());

        return orderDetailDTO;
    }

    public static OrderDetail toEntity(OrderDetailDTO orderDetailDTO) {
        if (orderDetailDTO == null) {
            return null;
        }

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId(orderDetailDTO.getDetailId());
        orderDetail.setOrderId(orderDetailDTO.getOrderId());
        orderDetail.setBookId(orderDetailDTO.getBookId());
        orderDetail.setQuantity(orderDetailDTO.getQuantity());
        orderDetail.setPrice(orderDetailDTO.getPrice());

        return orderDetail;
    }

    public static List<OrderDetailDTO> toDTOList(List<OrderDetail> orderDetails) {
        if (orderDetails == null) {
            return null;
        }
        return orderDetails.stream()
                .map(OrderDetailMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static List<OrderDetail> toEntityList(List<OrderDetailDTO> orderDetailDTOs) {
        if (orderDetailDTOs == null) {
            return null;
        }
        return orderDetailDTOs.stream()
                .map(OrderDetailMapper::toEntity)
                .collect(Collectors.toList());
    }
}
