package com.example.demo.models;

public class Greeting {
	private String content;
	private String sender;
    private String receiver;

    public Greeting() {}

   

    public Greeting(String content, String sender, String receiver) {
		super();
		this.content = content;
		this.sender = sender;
		this.receiver = receiver;
	}



	public String getContent() {
        return content;
    }

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}
    }
