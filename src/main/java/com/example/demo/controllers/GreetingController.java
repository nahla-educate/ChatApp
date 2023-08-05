package com.example.demo.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.example.demo.models.Greeting;
import com.example.demo.models.MessageHello;


@Controller
public class GreetingController {
	

		 @MessageMapping("/hello")
		    @SendTo("/topic/greetings")
		    public Greeting greeting(MessageHello payload) throws Exception {
		        Thread.sleep(1000); // Simulated delay
		        String sender = HtmlUtils.htmlEscape(payload.getName());
		        String content = HtmlUtils.htmlEscape(payload.getContent());
		        return new Greeting("Hello, " + sender + "!", sender, content);
		    }
		 
	    

		     @MessageMapping("/invitation")
		     @SendTo("/topic/invitations")
		     public Greeting invitation(MessageHello payload) throws Exception {
		         // Process the invitation payload and send the notification to the receiver
		         // You can use the InvitationService and WebSocket communication to send the invitation
		         // Example: invitationService.sendInvitation(sender, receiver);

		         String sender = HtmlUtils.htmlEscape(payload.getName());
		         String content = HtmlUtils.htmlEscape(payload.getContent());
		         return new Greeting("You received an invitation from " + sender + ".", sender, content);
		     }
	

}
