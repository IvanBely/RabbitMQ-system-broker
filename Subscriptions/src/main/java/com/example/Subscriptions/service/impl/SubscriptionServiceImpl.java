package com.example.Subscriptions.service.impl;

import com.example.Subscriptions.dto.request.PubDTO;
import com.example.Subscriptions.dto.response.NotificationDto;
import com.example.Subscriptions.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void processNewPublication(PubDTO pubDTO) {
        // 1. Определение подписчиков
        // Пример: получить список подписчиков автора публикации из базы данных
        // Здесь мы используем простой пример для иллюстрации
        List<String> subscribers = getSubscribers(pubDTO.getAuthorId());

        for (String subscriberId : subscribers) {
            // 2. Формирование уведомления
            // Создаем DTO для уведомления
            NotificationDto notificationDto = new NotificationDto();
            notificationDto.setSubscriberId(subscriberId);
            notificationDto.setMessage("New publication from " + pubDTO.getAuthorId() + ": " + pubDTO.getContent());

            // 3. Отправка уведомления в очередь
            rabbitTemplate.convertAndSend("notifications_exchange", "notifications.publication", notificationDto);
        }
    }
    private List<String> getSubscribers(String authorId) {
        // Логика для получения списка подписчиков
        // Например, из базы данных
        return Arrays.asList("11", "12");
    }
}
