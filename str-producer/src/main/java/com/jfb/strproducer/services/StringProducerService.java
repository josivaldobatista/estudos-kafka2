package com.jfb.strproducer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class StringProducerService {

  private final KafkaTemplate<String, String> kafkaTemplate;

  public void sendMessage(String message) {
    kafkaTemplate.send("str-topic", message)
        .addCallback(
            success -> {
              if (success != null) {
                log.info("Sending message with success \n{}", message);
                log.info("Partition: {}", success.getRecordMetadata().partition());
                log.info("Partition: {}", success.getRecordMetadata().offset());
              }
            },
            error -> log.info("Error send message")
        );
  }
}
