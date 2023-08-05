package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "invitationTable")
public class Invitation {


	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "sender_id")
	    private User sender;

	    @ManyToOne
	    @JoinColumn(name = "receiver_id")
	    private User receiver;

	    private String status; // "pending", "accepted", "declined", etc.

	    // Constructors, getters, setters
	    
	    
		public Invitation() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Invitation(Long id, User sender, User receiver, String status) {
			super();
			this.id = id;
			this.sender = sender;
			this.receiver = receiver;
			this.status = status;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public User getSender() {
			return sender;
		}

		public void setSender(User sender) {
			this.sender = sender;
		}

		public User getReceiver() {
			return receiver;
		}

		public void setReceiver(User receiver) {
			this.receiver = receiver;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

	 
	}
