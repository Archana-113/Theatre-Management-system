package com.project.Theatre_Management_System.exception;

public class ManagerIdNotFoundException extends RuntimeException{
	private String message="Manager Id not found";

	public String getMessage() {
		return message;
	}

}
