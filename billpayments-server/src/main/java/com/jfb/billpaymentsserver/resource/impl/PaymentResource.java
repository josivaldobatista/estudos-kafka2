package com.jfb.billpaymentsserver.resource.impl;

import com.jfb.billpaymentsserver.models.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface PaymentResource {

  @PostMapping
  ResponseEntity<Payment> payment(@RequestBody Payment payment);
}
