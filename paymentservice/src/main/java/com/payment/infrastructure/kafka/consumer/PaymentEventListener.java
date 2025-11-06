package com.payment.infrastructure.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.payment.application.port.in.ProcessPaymentUseCase;
import com.payment.domain.model.Payment;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentEventListener {
    private final ProcessPaymentUseCase processPaymentUseCase;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "order-events", groupId = "payment-group")
    public void consumeOrderEvent(String message) {
        try {
            log.info("Received order event: {}", message);
            Payment payment = objectMapper.readValue(message, Payment.class);
            processPaymentUseCase.processPayment(payment);
            log.info("Payment processed successfully for order: {}", payment.getOrderId());
        } catch (Exception e) {
            log.error("Error processing payment event: {}", message, e);
        }
    }
}