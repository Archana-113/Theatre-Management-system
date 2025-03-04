package com.project.Theatre_Management_System.exception;

public class TicketIdNotFoundException extends RuntimeException{
	private String message="Ticket Id not found";
	public String getMessage() {
		return message;
	}

}
