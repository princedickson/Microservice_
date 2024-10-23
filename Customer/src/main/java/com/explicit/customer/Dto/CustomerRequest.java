package com.explicit.customer.Dto;


public record CustomerRequest(
        String firstname,
        String lastname,
        String email
){}
