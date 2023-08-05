package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.models.MessageResponse;



@Service
public class WSService {
	 private final SimpMessagingTemplate messagingTemplate;
	   

	 @Autowired
	    public WSService(SimpMessagingTemplate messagingTemplate) {
	        this.messagingTemplate = messagingTemplate;
	       // this.notificationService = notificationService;
	    }

	    public void notifyFrontend(final String message) {
	    	MessageResponse response = new MessageResponse(message);
	       // notificationService.sendGlobalNotification();

	        messagingTemplate.convertAndSend("/topic/messages", response);
	    }

}
