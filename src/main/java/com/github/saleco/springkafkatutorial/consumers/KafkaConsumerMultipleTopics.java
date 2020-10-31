package com.github.saleco.springkafkatutorial.consumers;

import com.github.saleco.springkafkatutorial.config.KafkaConsumerConfig;
import com.github.saleco.springkafkatutorial.config.KafkaTopicConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumerMultipleTopics {

  @KafkaListener(topics = {KafkaTopicConfig.TOPIC_BAELDUNG, KafkaTopicConfig.TOPIC_BAELDUNG_2}, groupId = KafkaConsumerConfig.MY_FIRST_APPLICATION_GROUP_ID)
  public void listenToMultipleTopicsInGroup(String message) {
    log.info("Received Message in group " + KafkaConsumerConfig.MY_FIRST_APPLICATION_GROUP_ID + ": " + message);
  }

}
