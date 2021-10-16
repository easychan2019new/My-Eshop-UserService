package com.example.UserService.service;

import com.example.UserService.data.rest.AddPaymentResponse;
import com.example.UserService.data.rest.AddPaymentRest;
import com.example.UserService.data.rest.PaymentMethod;
import com.myeshop.Core.payment.query.FetchPaymentDetailQuery;
import com.myeshop.Core.payment.rest.PaymentDetail;

import java.util.List;

public interface PaymentService{
    PaymentDetail findPaymentDetail(FetchPaymentDetailQuery fetchPaymentDetailQuery);
    List<PaymentMethod> findPaymentMethod(String email);
    AddPaymentResponse addPayment(AddPaymentRest addPaymentRest);
}
