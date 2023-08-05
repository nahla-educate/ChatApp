package com.example.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.messaging.simp.SimpMessageSendingOperations;

import com.example.demo.message.ChatMessage;
import com.example.demo.message.MessageType;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
/*
@Component
@RequiredArgsConstructor
@Slf4j*/
public class WebSocketEventListener {
	/* private static final Logger log = LoggerFactory.getLogger(WebSocketEventListener.class);

	private final SimpMessageSendingOperations messageTemplate = null;
	@EventListener
	public void handleWebSocketDisconnectListener(
			SessionDisconnectEvent event) {
		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
		String username = (String) headerAccessor.getSessionAttributes().get("username");
		if(username != null) {
            log.info("User disconnected: {}", username);
            
            // Create a new chatMessage using the builder pattern and set its properties.
           /* ChatMessage chatmessage = ChatMessage.builder()
                .type(MessageType.LEAVER)
                .sender(username)
                .build();
            ChatMessage chatMessage = ChatMessage.create(MessageType.LEAVER, username);
            messageTemplate.convertAndSend("/topic/public", chatMessage);

		}
		
		
	}*/
	

}
