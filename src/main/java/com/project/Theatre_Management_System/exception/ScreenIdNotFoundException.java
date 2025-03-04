package com.project.Theatre_Management_System.exception;

public class ScreenIdNotFoundException extends RuntimeException{
	private String message="Screen Id not found";

	public String getMessage() {
		return message;
	}

}
