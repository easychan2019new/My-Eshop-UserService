package com.example.UserService.query;

import com.example.UserService.data.repository.PaymentRepository;
import com.example.UserService.service.PaymentService;
import com.myeshop.Core.payment.query.FetchPaymentDetailQuery;
import com.myeshop.Core.payment.rest.PaymentDetail;
import org.axonframework.queryhandling.QueryHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentQueryHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentQueryHandler.class);

    @Autowired
    private PaymentService paymentService;

    @QueryHandler
    public PaymentDetail findPaymentDetail(FetchPaymentDetailQuery fetchPaymentDetailQuery) {
        return paymentService.findPaymentDetail(fetchPaymentDetailQuery);
    }
}
