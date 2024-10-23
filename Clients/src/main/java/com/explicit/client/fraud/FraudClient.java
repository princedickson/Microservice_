package com.explicit.client.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "fraud")
public interface FraudClient {
    @GetMapping(path = "api/v1/fraud-check/{customerId}")
    FraudCheckResponse isFrudster(@PathVariable("customerId") Integer customerId);
}
