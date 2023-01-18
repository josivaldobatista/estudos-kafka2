package com.jfb.billpaymentsserver.services;

import com.jfb.billpaymentsserver.models.Payment;

public interface PaymentService {

  void sendPayment(Payment payment);
}
