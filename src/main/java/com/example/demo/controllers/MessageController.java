package com.example.demo.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.example.demo.models.Message;
import com.example.demo.models.MessageResponse;

@Controller
public class MessageController {
	
	@MessageMapping("/message")
	@SendTo("/topic/messages")
	
	public MessageResponse getMessage(final Message messaage) throws InterruptedException {
		Thread.sleep(1000);
		return new MessageResponse(HtmlUtils.htmlEscape(messaage.getMessageContent()));
		
	}
	
	

}
