package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.models.Invitation;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.InvitationService;

@RestController
@RequestMapping("/api/invitations")
public class InvitationController {

    private final InvitationService invitationService;
    private final UserRepository userRepository;

    @Autowired
    public InvitationController(InvitationService invitationService, UserRepository userRepository) {
        this.invitationService = invitationService;
        this.userRepository = userRepository;
    }

   /* @PostMapping("/send")
    public ResponseEntity<String> sendInvitation(@RequestParam Long senderId, @RequestParam Long receiverId) {
        User sender = userRepository.findById(senderId).orElse(null);
        User receiver = userRepository.findById(receiverId).orElse(null);
        if (sender == null || receiver == null) {
            return ResponseEntity.badRequest().body("Sender or receiver not found.");
        }

        Invitation invitation = invitationService.sendInvitation(sender, receiver);

        if (invitation != null) {
            return ResponseEntity.ok("Invitation sent successfully.");
        } else {
            return ResponseEntity.badRequest().body("Failed to send invitation.");
        }
    }*/
    @PostMapping("/send")
    public ResponseEntity<String> sendInvitation(@RequestParam Long senderId, @RequestParam String content) {
        User sender = userRepository.findById(senderId).orElse(null);
        if (sender == null) {
            return ResponseEntity.badRequest().body("Sender not found.");
        }

        // Broadcast the message to all connected clients
        Invitation invitation = invitationService.sendInvitation(sender);

        return ResponseEntity.ok("Message sent successfully.");
    }


    @PostMapping("/respond")
    public ResponseEntity<String> respondToInvitation(@RequestParam Long invitationId, @RequestParam String status) {
        Invitation invitation = invitationService.getInvitationById(invitationId);
        if (invitation == null) {
            return ResponseEntity.badRequest().body("Invitation not found.");
        }

        // Validate the status (e.g., "accepted", "declined", etc.)
        if (!isValidInvitationStatus(status)) {
            return ResponseEntity.badRequest().body("Invalid invitation status.");
        }

        // Update the invitation status
        invitation.setStatus(status);
        invitationService.saveInvitation(invitation);

        return ResponseEntity.ok("Invitation response recorded.");
    }

    // Utility method to validate the invitation status
    private boolean isValidInvitationStatus(String status) {
        // Add your validation logic here
        // For example, check if the status is one of "accepted", "declined", etc.
        // For simplicity, let's assume any non-empty string is valid.
        return status != null && !status.isEmpty();
    }
}
