package com.example.UserService.data.rest;

import lombok.Data;

@Data
public class AddAddressRest {

    private String contactName;
    private String contactPhone;
    private String street;
    private String country;
    private String city;
    private String state;
    private String zipCode;
    private String userEmail;
}
