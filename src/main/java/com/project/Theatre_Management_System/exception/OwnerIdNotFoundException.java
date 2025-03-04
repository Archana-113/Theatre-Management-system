package com.project.Theatre_Management_System.exception;

public class OwnerIdNotFoundException extends RuntimeException{
	
	private String message="Owner Id not found";

	public String getMessage() {
		return message;
	}

}
