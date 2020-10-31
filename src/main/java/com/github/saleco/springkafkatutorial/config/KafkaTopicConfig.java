package com.github.saleco.springkafkatutorial.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

  public static final String TOPIC_BAELDUNG = "baeldung";
  public static final String TOPIC_BAELDUNG_2 = "baeldung2";
  @Value(value="${kafka.bootstrapAddress}")
  private String bootstrapAddress;

  @Bean
  public KafkaAdmin kafkaAdmin() {
    Map<String, Object> configs = new HashMap<>();
    configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
    return new KafkaAdmin(configs);
  }

  @Bean
  public NewTopic topic1() {
    return new NewTopic(TOPIC_BAELDUNG, 3, (short) 1);
  }

  @Bean
  public NewTopic topic2() {
    return new NewTopic(TOPIC_BAELDUNG_2, 3, (short) 1);
  }
}
