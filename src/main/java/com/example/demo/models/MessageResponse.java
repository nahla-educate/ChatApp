package com.example.demo.models;

public class MessageResponse {
	
	
	public MessageResponse() {
			}

	public MessageResponse(String content) {
		
		this.content = content;
	}

	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
