package com.example.UserService.controller;

import com.example.UserService.data.entity.Country;
import com.example.UserService.data.entity.State;
import com.example.UserService.data.repository.AddressRepository;
import com.example.UserService.data.repository.CountryRepository;
import com.example.UserService.data.repository.StateRepository;
import com.example.UserService.data.rest.AddAddressResponse;
import com.example.UserService.data.rest.AddAddressRest;
import com.example.UserService.data.rest.AddressChoice;
import com.example.UserService.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("address") // http://localhost:8082/user-service/address
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressService addressService;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private StateRepository stateRepository;

    @GetMapping("/country")
    public List<Country> getCountry() {
        return countryRepository.findAll();
    }

    @GetMapping("/state")
    public List<State> getState(@RequestParam("countryName") String name) {
        return stateRepository.findByCountryName(name);
    }

    @GetMapping("/findAddressChoice")
    public List<AddressChoice> findAddressChoice(@RequestParam("email") String email) {
        return addressService.findAddressChoice(email);
    }

    @PostMapping("/addAddress")
    public AddAddressResponse addAddress(@RequestBody AddAddressRest addAddressRest) {
        return addressService.addAddress(addAddressRest);
    }
}
