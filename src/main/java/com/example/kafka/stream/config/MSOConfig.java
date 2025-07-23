package com.example.kafka.stream.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
public class MSOConfig {

    @Value("${kafka.business-event.managed-servicing-order-request.topic}")
    private String topic;

    @Value("${kafka.business-event.managed-servicing-order-request.supported-categories}")
    private Set<String> supportedCategories;

    @Value("${kafka.business-event.managed-servicing-order-request.supported-event-types}")
    private Set<String> supportedEventTypes;
}
