package com.purchaseorders.saga.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "test-topic", groupId = "my-consumer-group")
    public void listen(String message) {
    try {
        System.out.println("📩 Mensaje recibido: " + message);
    } catch (Exception e) {
        System.err.println("❌ Error procesando mensaje " + e.getMessage());
    }
}
}
