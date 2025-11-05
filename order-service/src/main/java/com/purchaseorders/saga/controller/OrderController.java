package com.purchaseorders.saga.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.purchaseorders.saga.service.OrderEventProducer;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderEventProducer producer;
    private final ObjectMapper objectMapper;

    @PostMapping
    public String createOrder(@RequestBody Map<String, Object> order) {
        try {
            String json = objectMapper.writeValueAsString(order);
            producer.sendOrderEvent(json);
            return "Order created and event sent!";
        } catch (Exception e) {
            throw new RuntimeException("Error converting order to JSON", e);
        }
    }
}
