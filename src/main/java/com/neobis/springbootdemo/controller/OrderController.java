package com.neobis.springbootdemo.controller;

import com.neobis.springbootdemo.dto.BookDTO;
import com.neobis.springbootdemo.dto.OrderDTO;
import com.neobis.springbootdemo.entity.Book;
import com.neobis.springbootdemo.entity.Order;
import com.neobis.springbootdemo.sevice.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService theOrderService) {
        orderService = theOrderService;
    }

    @GetMapping
    public List<OrderDTO> getAllOrders() {
        return orderService.findAll();
    }

    @GetMapping("/{orderId}")
    public OrderDTO getOrderById(@PathVariable Long orderId) {

        OrderDTO theOrder = orderService.findById(orderId);

        if (theOrder == null) {
            throw new RuntimeException("Order not found " + orderId);
        }
        return theOrder;
    }

    @PostMapping
    public OrderDTO addOrder(@RequestBody Order theOrder) {

        theOrder.setOrderId(0L);

        OrderDTO dbOrder = orderService.save(theOrder);

        return dbOrder;
    }

    @PutMapping
    public OrderDTO updateOrder(@RequestBody Order theOrder) {

        OrderDTO dbOrder = orderService.save(theOrder);
        return dbOrder;
    }

    @DeleteMapping("/{orderId}")
    public String deleteOrderById(@PathVariable Long orderId) {

        OrderDTO tempOrder = orderService.findById(orderId);

        if (tempOrder == null) {
            throw new RuntimeException("Order with id " + orderId + " NOT FOUND!");
        }

        orderService.deleteById(orderId);
        return "Order with id " + orderId + " was deleted";
    }



}
