package com.purchaseorders.saga.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderEventProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${topic.name:order-events}")
    private String topic;

    public void sendOrderEvent(String orderJson) {
        kafkaTemplate.send(topic, orderJson);
        log.info("Order Event Sent: " + orderJson);
    }
}

