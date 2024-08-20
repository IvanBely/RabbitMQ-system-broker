package com.example.Publications.service;

import com.example.Publications.dto.request.NewRequest;

public interface PublicationService {
    void publish(NewRequest request);
}
