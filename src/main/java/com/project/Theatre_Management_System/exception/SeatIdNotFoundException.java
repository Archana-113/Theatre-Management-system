package com.project.Theatre_Management_System.exception;

public class SeatIdNotFoundException extends RuntimeException{
	private String message="Seat Id not found";
	public String getMessage() {
		return message;
	}

}
