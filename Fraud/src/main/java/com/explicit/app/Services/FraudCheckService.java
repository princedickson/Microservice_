package com.explicit.app.Services;

import com.explicit.app.Model.FraudCheckHistory;
import com.explicit.app.Repostitory.FraudRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {
    private final FraudRepository fraudCheckRepository;

    public boolean isFraudulentCustomer(Integer customerId) {
        fraudCheckRepository.save(FraudCheckHistory.builder()
                .customerId(customerId)
                .createdAt(LocalDateTime.now())
                .isfraudster(false)
                .build());
        return false;
    }
}
