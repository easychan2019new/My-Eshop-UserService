package com.example.UserService.data.repository;

import com.example.UserService.data.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, String> {

    List<Address> findByUserEmail(String email);
}
