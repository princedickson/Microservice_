package com.explicit.app.Service;

import com.explicit.app.Mdoel.Notification;
import com.explicit.app.Repository.NotificationRepository;
import com.explicit.client.fraud.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;
    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(Notification.builder()
                        .toCustomerId(notificationRequest.toCustomerId())
                        .toCustomerEmail(notificationRequest.toCustomerEmail())
                        .sentAt(LocalDateTime.now())
                        .message(notificationRequest.message())
                        .sender("Explicit")
                .build());
    }
}
