package com.example.UserService.data.rest;

import lombok.Data;

@Data
public class AddPaymentRest {

    private String cardNumber;
    private String cvv;
    private String name;
    private int validUntilMonth;
    private int validUntilYear;
    private String userEmail;
}
