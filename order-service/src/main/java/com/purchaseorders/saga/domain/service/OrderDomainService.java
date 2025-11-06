package com.purchaseorders.saga.domain.service;

import com.purchaseorders.saga.domain.event.OrderCreatedEvent;
import com.purchaseorders.saga.infrastructure.kafka.producer.OrderEventProducer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderDomainService {

    private final OrderEventProducer kafkaOrderProducer;

    public void createOrder(OrderCreatedEvent createEvent) {
        // Lógica de negocio del dominio
        if(createEvent.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }

        OrderCreatedEvent event = 
        OrderCreatedEvent.builder()
        .orderId(createEvent.getOrderId())
        .productId(createEvent.getProductId())    
        .quantity(createEvent.getQuantity())    
        .price(createEvent.getPrice())
        .build();      

        // Publica evento
        kafkaOrderProducer.publish(event);
    }
}
