package com.example.Subscriptions.service;

import com.example.Subscriptions.dto.request.PubDTO;

public interface SubscriptionService {
    void processNewPublication(PubDTO pubDTO);
}
