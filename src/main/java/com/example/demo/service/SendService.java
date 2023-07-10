package com.example.demo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.KafkaAdminClient;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Slf4j
@RequiredArgsConstructor
@Service
public class SendService {
    private final RabbitTemplate rabbitTemplate;
    private final Queue myQueue;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMsg(String msg) {
        rabbitTemplate.convertAndSend(myQueue.getName(),msg);
    }

    public void sendTopicMsg(String msg, String route) {
        rabbitTemplate.convertAndSend("topicExchange", route, msg);
    }
    public void sendMessage2(String id) {

        log.info("-----------------------");
        try {
            //同步
            kafkaTemplate.send("chu",id).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //异步
        kafkaTemplate.send("chu","123");

    }
}
