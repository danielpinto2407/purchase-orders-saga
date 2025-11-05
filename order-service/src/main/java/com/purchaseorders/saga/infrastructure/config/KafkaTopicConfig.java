package com.purchaseorders.saga.infrastructure.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class KafkaTopicConfig {

    @Value("${topic.order-events.name:order-events}")
    private String orderEventsTopic;

    @Bean
    public NewTopic orderEventsTopic() {
        return new NewTopic(orderEventsTopic, 1, (short) 1);
    }
}
