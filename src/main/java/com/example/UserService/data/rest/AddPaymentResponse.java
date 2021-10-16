package com.example.UserService.data.rest;

import lombok.Data;
import lombok.NonNull;

@Data
public class AddPaymentResponse {

    @NonNull
    private String cardNumber;
}
