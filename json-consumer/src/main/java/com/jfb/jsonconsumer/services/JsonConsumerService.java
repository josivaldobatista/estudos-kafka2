package com.jfb.jsonconsumer.services;

import com.jfb.jsonconsumer.models.Payment;
import com.jfb.jsonconsumer.repository.JsonConsumerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JsonConsumerService {

  private final JsonConsumerRepository repository;

  public void salvar(Payment payment) {
    repository.save(payment);
  }
}
