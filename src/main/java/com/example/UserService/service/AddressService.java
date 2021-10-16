package com.example.UserService.service;

import com.example.UserService.data.rest.AddAddressResponse;
import com.example.UserService.data.rest.AddAddressRest;
import com.example.UserService.data.rest.AddressChoice;

import java.util.List;

public interface AddressService {

    List<AddressChoice> findAddressChoice(String email);

    AddAddressResponse addAddress(AddAddressRest addAddressRest);
}
