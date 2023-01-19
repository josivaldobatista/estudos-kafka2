package com.jfb.jsonconsumer.listener;

import com.jfb.jsonconsumer.models.Payment;
import com.jfb.jsonconsumer.services.JsonConsumerService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

@Component
@Log4j2
@RequiredArgsConstructor
public class JsonListener {

  private final JsonConsumerService service;

  @SneakyThrows
  @KafkaListener(
      topics = "payment-topic",
      groupId = "create-group",
      containerFactory = "jsonContainerFactory")
  public void antFraud(@Payload Payment payment) {
    log.info("Recebi o pagamento: {}", payment.toString());
    sleep(2000);
    log.info("Validando fraud ...");
    sleep(2000);
    log.info("Compra aprovada...");
    service.salvar(payment);
    sleep(3000);
  }

  @SneakyThrows
  @KafkaListener(
      topics = "payment-topic",
      groupId = "pdf-group",
      containerFactory = "jsonContainerFactory")
  public void pdfGenerator(@Payload Payment payment) {
    log.info("Gerando PDF do produto de id {}...", payment.getId());
    sleep(2000);
  }

  @SneakyThrows
  @KafkaListener(
      topics = "payment-topic",
      groupId = "email-group",
      containerFactory = "jsonContainerFactory")
  public void sendEmail() {
    log.info("Enviando email de confirmação ...");
    sleep(2000);
  }
}
