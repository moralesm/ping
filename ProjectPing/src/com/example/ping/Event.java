package com.example.ping;

public class Event {
	
	    public String title;
	    public String host;
	    public String location;
	    public String date;
	    public String time;
	    // include other parameters 
	    
	    public Event(){
	        super();
	    }
	    
	    public Event(String title, String host, String location, String date, String time) {
	        super();
	        this.title = title + " by " + host;
	        this.location = location;
	        this.date = date;
	        this.time = time;
	    }
	}
