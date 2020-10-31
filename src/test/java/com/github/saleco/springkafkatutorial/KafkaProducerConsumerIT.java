package com.github.saleco.springkafkatutorial;

import com.github.saleco.springkafkatutorial.config.KafkaTopicConfig;
import com.github.saleco.springkafkatutorial.consumers.KafkaConsumer;
import com.github.saleco.springkafkatutorial.consumers.KafkaConsumerMultipleTopics;
import com.github.saleco.springkafkatutorial.consumers.KafkaConsumerSpecificPartition;
import com.github.saleco.springkafkatutorial.producers.KafkaProducer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class KafkaProducerConsumerIT {

  @Autowired
  KafkaProducer kafkaProducer;

  @Autowired
  KafkaConsumer kafkaConsumer;

  @Autowired
  KafkaConsumerMultipleTopics kafkaConsumerMultipleTopics;

  @Autowired
  KafkaConsumerSpecificPartition kafkaConsumerSpecificPartition;

  @BeforeEach
  void setUp() {
    for (int i = 0; i < 1000; i++) {
      kafkaProducer.sendMessage("Test message #" + i, KafkaTopicConfig.TOPIC_BAELDUNG);
      kafkaProducer.sendMessage("Test message #" + i, KafkaTopicConfig.TOPIC_BAELDUNG_2);
    }


  }

  @Test
  public void testProducerConsumer() {

  }
}
