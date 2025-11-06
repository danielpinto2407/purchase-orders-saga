package com.purchaseorders.saga.domain.event;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderCreatedEvent implements OrderEvent {
    private final String orderId;
    private final String productId;
    private final Integer quantity;
    private final Double price;
}

