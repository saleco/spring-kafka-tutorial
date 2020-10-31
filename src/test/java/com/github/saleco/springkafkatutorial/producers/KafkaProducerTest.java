package com.github.saleco.springkafkatutorial.producers;

import com.github.saleco.springkafkatutorial.config.KafkaTopicConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KafkaProducerTest {

  @Autowired
  KafkaProducer kafkaProducer;

  @Test
  public void sendMessage() {
    for (int i = 0; i < 1000; i++) {
      kafkaProducer.sendMessage("Test message #" + i, KafkaTopicConfig.TOPIC_BAELDUNG);
      kafkaProducer.sendMessage("Test message #" + i, KafkaTopicConfig.TOPIC_BAELDUNG_2);
    }

  }

}
