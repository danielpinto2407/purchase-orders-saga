package com.payment.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PaymentEventListener {

    @KafkaListener(topics = "order-events", groupId = "payment-group")
    public void consumeOrderEvent(String message) {
        log.info("Payment Service Received Order Event: " + message);

        // Simular lógica de pago
        log.info("Processing payment for order...");
    }
}

