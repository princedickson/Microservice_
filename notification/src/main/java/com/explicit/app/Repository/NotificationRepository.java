package com.explicit.app.Repository;

import com.explicit.app.Mdoel.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
