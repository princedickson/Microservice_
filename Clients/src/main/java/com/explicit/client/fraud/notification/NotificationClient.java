package com.explicit.client.fraud.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "notification")
public interface NotificationClient {
    @PostMapping("api/v1/notification")
    void NotificationResponse(NotificationRequest notificationRequest);
}
