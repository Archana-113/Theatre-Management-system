package com.project.Theatre_Management_System.exception;

public class TheatreIdNotFoundException extends RuntimeException {
	private String message="Theatre Id not found";

	public String getMessage() {
		return message;
	}

}
