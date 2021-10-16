package com.example.UserService.controller;

import com.example.UserService.data.entity.Payment;
import com.example.UserService.data.repository.PaymentRepository;
import com.example.UserService.data.repository.UserRepository;
import com.example.UserService.data.rest.AddPaymentResponse;
import com.example.UserService.data.rest.AddPaymentRest;
import com.example.UserService.data.rest.PaymentMethod;
import com.example.UserService.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("payment") // http://localhost:8082/user-service/payment
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/findPayment")
    public Payment findPayment(@RequestParam("id") String id) {
        return paymentRepository.findPaymentById(id);
    }

    @GetMapping("/findPaymentMethod")
    public List<PaymentMethod> findPaymentMethod(@RequestParam("email") String email) {
        return paymentService.findPaymentMethod(email);
    }

    @PostMapping("/addPayment")
    public AddPaymentResponse addPayment(@RequestBody AddPaymentRest addPaymentRest) {
        return paymentService.addPayment(addPaymentRest);
    }
}
