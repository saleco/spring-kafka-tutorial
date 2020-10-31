package com.github.saleco.springkafkatutorial.producers;

import com.github.saleco.springkafkatutorial.config.KafkaTopicConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@RequiredArgsConstructor
@Component
public class KafkaProducer {

  private final KafkaTemplate<String, String> kafkaTemplate;

  public void sendMessage(String message, String topic) {
    ListenableFuture<SendResult<String, String>> future =
        kafkaTemplate.send(topic, message);

    future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
      @Override
      public void onFailure(Throwable ex) {
        log.error("Unable to send message=[" + message + "] due to: " + ex.getMessage());
      }

      @Override
      public void onSuccess(SendResult<String, String> result) {
        log.info("Sent message=[" + message + "] with offset=["
            + result.getRecordMetadata().offset() + "]");
      }
    });

  }

}
