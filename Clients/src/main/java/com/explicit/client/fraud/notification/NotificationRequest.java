package com.explicit.client.fraud.notification;

import java.io.Serializable;

public record NotificationRequest(
       Integer toCustomerId,
       String toCustomerEmail,
       String message
) {
}
