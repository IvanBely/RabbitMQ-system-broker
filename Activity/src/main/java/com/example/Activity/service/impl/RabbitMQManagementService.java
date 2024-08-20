package com.example.Activity.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RabbitMQManagementService {

    @Value("${rabbitmq.management.url}")
    private String managementUrl;

    private final RestTemplate restTemplate;

    public RabbitMQManagementService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<String> getQueuesForExchange(String exchangeName) {
        String url = String.format("%s/api/exchanges/%2f/%s/bindings/source", managementUrl, exchangeName);
        Map<String, Object>[] bindings = restTemplate.getForObject(url, Map[].class);

        return Arrays.stream(bindings)
                .map(binding -> (String) binding.get("destination"))
                .collect(Collectors.toList());
    }
}
