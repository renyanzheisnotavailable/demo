package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class QueueConsumer {
    @RabbitListener(queues = {"ss007"})
    public void receive(@Payload String fileBody) {
        log.info("ss007队列" + fileBody);
    }

    @KafkaListener(topics = {"chu"})
    public void consumer(ConsumerRecord<String, String> consumerRecord) {
        log.info(consumerRecord.toString());
    }

}
