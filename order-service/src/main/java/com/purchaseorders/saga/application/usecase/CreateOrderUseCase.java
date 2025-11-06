package com.purchaseorders.saga.application.usecase;

import com.purchaseorders.saga.domain.event.OrderCreatedEvent;
import com.purchaseorders.saga.domain.service.OrderDomainService;
import com.purchaseorders.saga.infrastructure.controller.dto.CreateOrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateOrderUseCase {

    private final OrderDomainService orderDomainService;

    public void execute(CreateOrderRequest request) {
        // Convertir el DTO en un evento o entidad de dominio
        OrderCreatedEvent event = 
            OrderCreatedEvent.builder()
            .orderId(request.getOrderId())
            .productId(request.getProductId())
            .quantity(request.getQuantity())
            .price(request.getPrice())
            .build();

        orderDomainService.createOrder(event);
    }
}
