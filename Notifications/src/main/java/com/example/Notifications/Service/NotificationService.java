package com.example.Notifications.Service;

import com.example.Notifications.dto.request.SubDTO;

public interface NotificationService {
    void sendNotification(SubDTO subDTO);
}
