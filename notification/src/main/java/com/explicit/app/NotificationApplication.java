package com.explicit.app;

import com.explicit.amqp.RabbitMqMessageProducer;
import com.explicit.app.config.NotificationConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
        scanBasePackages = {
                "com.explicit.app",
                "com.explicit.amqp",
        }
)
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

  /*  @Bean
    CommandLineRunner commandLineRunner(RabbitMqMessageProducer producer, NotificationConfig notificationConfig){
        return args -> {
            producer.publish("topic",
                    notificationConfig.getInternalExchange(),
                    notificationConfig.getInternalRoutingKey());
        };
    }*/
}