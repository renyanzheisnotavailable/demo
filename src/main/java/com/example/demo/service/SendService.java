package com.example.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SendService {
    private final RabbitTemplate rabbitTemplate;
    private final Queue myQueue;

    public void sendMsg(String msg) {
        rabbitTemplate.convertAndSend(myQueue.getName(),msg);
    }

    public void sendTopicMsg(String msg, String route) {
        rabbitTemplate.convertAndSend("topicExchange", route, msg);
    }
}
