package com.ms.edu.comment.controller;

import com.ms.edu.comment.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ClassName: Mq
 * Package: com.ms.edu.comment.controller
 * Description:
 *
 * @Author ms
 * @Create 2024/6/21 9:59
 * @Version 1.0
 */
@RestController
@RequestMapping("/mq")
public class Mq {
    @Resource
    private MessageService messageService;

    @GetMapping("/send")
    public void sendMessageToClient(String message) {
        messageService.sendMessage("/topic/greetings", message);
    }
}
