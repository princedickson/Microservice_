package com.explicit.app.rabbitmq;

import com.explicit.app.Service.NotificationService;
import com.explicit.client.fraud.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consumer(NotificationRequest notificationRequest){
        log.info("consumed {} from queue", notificationRequest);
        notificationService.send(notificationRequest);
    }
}
