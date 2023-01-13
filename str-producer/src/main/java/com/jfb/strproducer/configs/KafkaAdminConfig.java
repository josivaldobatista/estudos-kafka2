package com.jfb.strproducer.configs;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;

@Configuration
@RequiredArgsConstructor
public class KafkaAdminConfig {

  public final KafkaProperties properties;

  @Bean
  public KafkaAdmin kafkaAdmin() {
    var confis = new HashMap<String, Object>();
    confis.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
    return new KafkaAdmin(confis);
  }

  @Bean
  public KafkaAdmin.NewTopics topics() {
    return new KafkaAdmin.NewTopics(TopicBuilder.name("str-topic")
            .partitions(2)
            .replicas(1)
            .build());
  }

}
