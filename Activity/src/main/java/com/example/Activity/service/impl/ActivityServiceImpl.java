package com.example.Activity.service.impl;

import com.example.Activity.dto.RequestDTO;
import com.example.Activity.service.ActivityService;

public class ActivityServiceImpl implements ActivityService {
    @Override
    public void processActivity(RequestDTO requestDTO) {

        String message = "Уведомление для пользователя " + requestDTO.getUserID() + ": " + requestDTO.getMessage();
        // Логика отправка уведомлений
        System.out.println(message);
    }
}
