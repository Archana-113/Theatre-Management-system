package com.project.Theatre_Management_System.exception;

public class ReviewIdNotFoundException extends RuntimeException {
	private String message="Review Id not found";
	public String getMessage() {
		return message;
	}

}
