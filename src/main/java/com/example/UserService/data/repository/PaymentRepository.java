package com.example.UserService.data.repository;

import com.example.UserService.data.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, String> {

    Payment findPaymentById(String id);

    List<Payment> findByUserEmail(String email);
}
