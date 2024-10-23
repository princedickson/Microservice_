package com.explicit.customer.Services;

import com.explicit.amqp.RabbitMqMessageProducer;
import com.explicit.client.fraud.FraudCheckResponse;
import com.explicit.client.fraud.FraudClient;
import com.explicit.client.fraud.notification.NotificationRequest;
import com.explicit.customer.Dto.CustomerRequest;
import com.explicit.customer.Model.Customer;
import com.explicit.customer.Repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final RabbitMqMessageProducer rabbitMqMessageProducer;

    public void registerCustomer(CustomerRequest customerRequest) {
        Customer customer = Customer.builder()
                .firstname(customerRequest.firstname())
                .lastname(customerRequest.lastname())
                .email(customerRequest.email())
                .build();

        // todo :check if email is valid
        // todo: check if email is not taken

        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = fraudClient.isFrudster(customer.getId());

        if (Boolean.TRUE.equals(fraudCheckResponse.isFraudster())) {
            throw new IllegalStateException("fraudster");
        }

        // make it sync i.e add to queue
        final NotificationRequest notificationRequest = new NotificationRequest(customer.getId(), customer.getEmail(),
                String.format("Hi %s welcome to spring boot microservice course.. ", customer.getFirstname())
        );

        rabbitMqMessageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"
        );
    }
}
