package com.project.Theatre_Management_System.exception;

public class MovieIdNotFoundException extends RuntimeException{
	private String message="Movie Id not found";

	public String getMessage() {
		return message;
	}

}
