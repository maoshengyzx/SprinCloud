package com.ms.edu.comment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
 
@Service
public class MessageService {
 
    @Autowired
    private SimpMessagingTemplate template;
 
    public void sendMessage(String destination, String message) {
        this.template.convertAndSend(destination, message);
    }
}