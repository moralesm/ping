package com.example.ping;

public class Contact {
	public String name;
	public String number;
	public String email;

	public Contact(){
		super();
	}

	public Contact(String name, String number){
		super();
		this.name = name;
		this.number=number;
	}

	public Contact(String name, String number, String email) {
		super();
		this.name = name;
		this.number = number;
		this.email = email;
	}

}
