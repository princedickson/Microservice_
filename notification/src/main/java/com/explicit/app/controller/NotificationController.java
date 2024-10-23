package com.explicit.app.controller;

import com.explicit.app.Service.NotificationService;
import com.explicit.client.fraud.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/notification")
@Slf4j
@AllArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;
    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notificationRequest){
        log.info("notification message sent {}", notificationRequest);
        notificationService.send(notificationRequest);
    }
}
