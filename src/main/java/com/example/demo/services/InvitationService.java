package com.example.demo.services;

import org.springframework.stereotype.Service;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import com.example.demo.models.Invitation;
import com.example.demo.models.User;
import com.example.demo.repositories.InvitationRepository;

@Service
public class InvitationService {
	
	private final InvitationRepository invitationRepository;

	    @Autowired
	    public InvitationService(InvitationRepository invitationRepository) {
	        this.invitationRepository = invitationRepository;
	    }

	    public Invitation sendInvitation(User sender) {
	        // Here you can perform any business logic related to sending invitations
	        // For example, you might want to create an Invitation object and save it to the database

	        // Create an Invitation object (if needed) and set its properties
	        Invitation invitation = new Invitation();
	        invitation.setSender(sender);
	        invitation.setStatus("pending");

	        // Save the invitation to the database (if needed)
	        // For example, if you have a JPA repository for Invitations:
	        // invitationRepository.save(invitation);

	        // Once the invitation is saved (if applicable), you can broadcast the message
	        // to all connected clients using the WebSocketService
	        invitationRepository.save(invitation);

	        // Return the created invitation (if needed)
	        return invitation;
	    }

	    /*public Invitation sendInvitation(User sender, User receiver) {
	        // Create a new Invitation object and save it in the database
	        Invitation invitation = new Invitation();
	        invitation.setSender(sender);
	        invitation.setReceiver(receiver);
	        invitation.setStatus("pending"); // Set the initial status as "pending"

	        return invitationRepository.save(invitation);
	    }*/

	    public Invitation getInvitationById(Long invitationId) {
	        return invitationRepository.findById(invitationId).orElse(null);
	    }


	    public void saveInvitation(Invitation invitation) {
	        invitationRepository.save(invitation);
	    }
	}
