package com.jfb.strconsumer.exceptions;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class ErrorCustomHandler implements KafkaListenerErrorHandler {
  @Override
  public Object handleError(Message<?> message, ListenerExecutionFailedException e) {
  log.info("EXCEPTION_HADLER :::: Capturei um erro!");
    log.info("Headers ::: {}", message.getHeaders());
    log.info("Offset ::: {}", message.getHeaders().get("kafka_offset"));
    log.info("Payload ::: {}", message.getPayload());
    log.info("Message exception ::: {}", e.getMessage());
    return null;
  }

//  @Override
//  public Object handleError(Message<?> message, ListenerExecutionFailedException exception, Consumer<?, ?> consumer) {
//    return KafkaListenerErrorHandler.super.handleError(message, exception, consumer);
//  }
}
