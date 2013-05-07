package com.example.ping;

import java.util.ArrayList;

public class Event {
	
	    public String title;
	    public String host;
	    public String location;
	    public String date;
	    public String time;
	    public ArrayList<String> invitedFriends;
	    public ArrayList<String> attending;
	    public ArrayList<String> notAttending;
	    public ArrayList<String> notAnsweredYet;
	    
	    
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
	    
	    
	    public ArrayList<String> getInvitedFriends() {
			return invitedFriends;
		}

		public void setInvitedFriends(ArrayList<String> invitedFriends) {
			this.invitedFriends = invitedFriends;
		}

		public ArrayList<String> getAttending() {
			return attending;
		}

		public void setAttending(ArrayList<String> attending) {
			this.attending = attending;
		}

		public ArrayList<String> getNotAttending() {
			return notAttending;
		}

		public void setNotAttending(ArrayList<String> notAttending) {
			this.notAttending = notAttending;
		}

		public ArrayList<String> getNotAnsweredYet() {
			return notAnsweredYet;
		}

		public void setNotAnsweredYet(ArrayList<String> notAnsweredYet) {
			this.notAnsweredYet = notAnsweredYet;
		}


	    
	    
	}
