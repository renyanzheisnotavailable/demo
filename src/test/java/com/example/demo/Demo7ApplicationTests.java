package com.example.demo;

import com.example.demo.service.QueueConsumer;
import com.example.demo.service.SendService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo7ApplicationTests {

    @Autowired
    public SendService sendService;
    public QueueConsumer queueConsumer;

    @Test
    void contextLoads() {
    }

    @Test
    void kafka(){
        sendService.sendMessage2("chu");
    }

}
