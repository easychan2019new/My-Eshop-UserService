package com.example.UserService.service;

import com.example.UserService.data.entity.Payment;
import com.example.UserService.data.entity.User;
import com.example.UserService.data.repository.PaymentRepository;
import com.example.UserService.data.repository.UserRepository;
import com.example.UserService.data.rest.AddPaymentResponse;
import com.example.UserService.data.rest.AddPaymentRest;
import com.example.UserService.data.rest.PaymentMethod;
import com.myeshop.Core.payment.query.FetchPaymentDetailQuery;
import com.myeshop.Core.payment.rest.PaymentDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService{

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public PaymentDetail findPaymentDetail(FetchPaymentDetailQuery fetchPaymentDetailQuery) {
        Payment payment = paymentRepository.findPaymentById(fetchPaymentDetailQuery.getPaymentId());
        PaymentDetail paymentDetail = new PaymentDetail();
        BeanUtils.copyProperties(payment, paymentDetail);
        return paymentDetail;
    }

    @Override
    public List<PaymentMethod> findPaymentMethod(String email) {
        List<Payment> paymentList = paymentRepository.findByUserEmail(email);
        List<PaymentMethod> ans = new ArrayList<>();
        for (Payment payment: paymentList) {
            PaymentMethod method = new PaymentMethod();
            method.setId(payment.getId());
            method.setCardNumber(payment.getCardNumber());
            ans.add(method);
        }
        return ans;
    }

    @Override
    public AddPaymentResponse addPayment(AddPaymentRest addPaymentRest) {
        // get user
        User user = userRepository.findByEmail(addPaymentRest.getUserEmail());
        if (user == null) {
            user = new User();
            user.setEmail(addPaymentRest.getUserEmail());
        }
        List<Payment> paymentList = user.getPaymentList();
//        LOGGER.info(paymentList.toString());
        // add the payment to paymentList
        Payment payment = new Payment();
        payment.setId(UUID.randomUUID().toString());
        BeanUtils.copyProperties(addPaymentRest, payment);

        user.addPayment(payment);
        userRepository.save(user);
        return new AddPaymentResponse(addPaymentRest.getCardNumber());
    }
}
