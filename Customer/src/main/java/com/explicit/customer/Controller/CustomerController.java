package com.explicit.customer.Controller;

import com.explicit.customer.Dto.CustomerRequest;
import com.explicit.customer.Services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customer")
@Slf4j
public record CustomerController(CustomerService customerService)
{
    @PostMapping
    public void registerCostumer( @RequestBody CustomerRequest customerRequest){
        customerService.registerCustomer(customerRequest);
        log.info("new Customer registration {}", customerRequest);
    }
}
