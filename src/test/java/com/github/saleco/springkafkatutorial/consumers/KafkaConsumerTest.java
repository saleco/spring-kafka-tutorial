package com.github.saleco.springkafkatutorial.consumers;

import com.github.saleco.springkafkatutorial.config.KafkaTopicConfig;
import com.github.saleco.springkafkatutorial.consumers.KafkaConsumer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KafkaConsumerTest {

  @Autowired
  KafkaConsumer kafkaConsumer;

  @Test
  public void listenToTopicInGroup() {

  }

}
