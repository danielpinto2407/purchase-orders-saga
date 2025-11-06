package com.purchaseorders.saga.infrastructure.controller.dto;

import lombok.Data;

@Data
public class CreateOrderRequest {
    private String orderId;
    private String productId;
    private Integer quantity;
    private Double price;
}
