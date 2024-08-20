package com.example.Notifications.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationsToUsersDTO {
    private String subscriberId;
    private String message;
    private String details;
}
