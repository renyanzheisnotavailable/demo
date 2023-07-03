package com.example.demo.controller;

import com.example.demo.service.SendService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/trigger")
public class TriggerController {

    private final SendService sendService;

    @GetMapping("/send")
    public String sendMsgToMq(@RequestParam String msg){
        sendService.sendMsg(msg);
        return "ok";
    }

}
