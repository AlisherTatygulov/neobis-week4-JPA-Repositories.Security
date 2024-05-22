package com.neobis.springbootdemo.dto;

import jakarta.persistence.Column;

public class OrderDetailDTO {
    private Long detailId;
    private Long orderId;
    private Long bookId;
    private int quantity;
    private double price;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(Long detailId, Long orderId, Long bookId, int quantity, double price) {
        this.detailId = detailId;
        this.orderId = orderId;
        this.bookId = bookId;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
