package com.jfb.strproducer.configs;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;

@Configuration
@RequiredArgsConstructor
public class StringProducerFactoryConfig {

  private final KafkaProperties properties;

  @Bean
  public ProducerFactory<String, String> producerFactory() {
    var config = new HashMap<String, Object>();
    config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers()); // <- Pegando o valor do application.yml "localhost:29092"
    config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class); // <- Objeto que vai fazer a serialização da nossa chave (serializador da chave)
    config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class); // <- Objeto que vai fazer a serialização do valor (serializador da valor)
    return new DefaultKafkaProducerFactory<>(config);
  }

  /*
  * KAFKA TEMPLATE
  * Vai usar o ProducerFactory para enviar as mensagens para o topico
  * */
  @Bean
  KafkaTemplate<String, String> kafkaTemplate(ProducerFactory<String, String> producerFactory) {
    return new KafkaTemplate<>(producerFactory);
  }
}
