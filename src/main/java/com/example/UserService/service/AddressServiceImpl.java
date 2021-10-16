package com.example.UserService.service;

import com.example.UserService.data.entity.Address;
import com.example.UserService.data.entity.User;
import com.example.UserService.data.repository.AddressRepository;
import com.example.UserService.data.repository.UserRepository;
import com.example.UserService.data.rest.AddAddressResponse;
import com.example.UserService.data.rest.AddAddressRest;
import com.example.UserService.data.rest.AddressChoice;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<AddressChoice> findAddressChoice(String email) {
        List<Address> addressList = addressRepository.findByUserEmail(email);
        List<AddressChoice> ans = new ArrayList<>();
        for (Address address: addressList) {
            AddressChoice choice = new AddressChoice();
            choice.setId(address.getId());
            choice.setStreet(address.getStreet());
            ans.add(choice);
        }
        return ans;
    }

    @Override
    public AddAddressResponse addAddress(AddAddressRest addAddressRest) {
        // get user
        User user = userRepository.findByEmail(addAddressRest.getUserEmail());
        if (user == null) {
            user = new User();
            user.setEmail(addAddressRest.getUserEmail());
        }
        List<Address> addressList = user.getAddressList();

        // add the address to addressList
        Address address = new Address();
        address.setId(UUID.randomUUID().toString());
        BeanUtils.copyProperties(addAddressRest, address);

        user.addAddress(address);
        userRepository.save(user);
        return new AddAddressResponse(addAddressRest.getStreet());
    }

}
