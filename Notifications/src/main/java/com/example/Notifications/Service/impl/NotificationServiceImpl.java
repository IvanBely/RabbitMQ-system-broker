package com.example.Notifications.Service.impl;

import com.example.Notifications.Service.NotificationService;
import com.example.Notifications.dto.request.SubDTO;
import com.example.Notifications.dto.response.NotificationsToUsersDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    @Override
    public void sendNotification(SubDTO subDTO) {
        // Логика отправки уведомления пользователю
        // Здесь можно реализовать персонализацию уведомлений
        String message = "Уведомление для пользователя " + subDTO.getSubscriberId() + ": " + subDTO.getMessage();
        NotificationsToUsersDTO notificationsToUsersDTO = new NotificationsToUsersDTO(subDTO.getSubscriberId(), subDTO.getMessage(), message);
        System.out.println(message);
    }
}
