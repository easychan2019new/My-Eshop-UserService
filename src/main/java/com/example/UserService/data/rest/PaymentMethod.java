package com.example.UserService.data.rest;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class PaymentMethod {

    private String id;
    private String cardNumber;
}
