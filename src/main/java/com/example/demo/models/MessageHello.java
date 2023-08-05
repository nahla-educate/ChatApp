package com.example.demo.models;

public class MessageHello {

    private String name;
    private String content;

    public MessageHello() {}

    

    public MessageHello(String name, String content) {
		super();
		this.name = name;
		this.content = content;
	}



	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
