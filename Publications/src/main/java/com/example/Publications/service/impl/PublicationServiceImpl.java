package com.example.Publications.service.impl;

import com.example.Publications.dto.request.NewRequest;
import com.example.Publications.dto.response.PostRequest;
import com.example.Publications.service.PublicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublicationServiceImpl implements PublicationService {
    private final RabbitTemplate rabbitTemplate;
    @Override
    public void publish(NewRequest newRequest) {
        // creating publication...
        PostRequest request = new PostRequest(newRequest.getAuthorId(), newRequest.getContent());

        rabbitTemplate.convertAndSend("new_publications", "", request);
    }
}
