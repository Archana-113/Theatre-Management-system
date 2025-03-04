package com.project.Theatre_Management_System.exception;

public class AddressIdNotFoundException extends RuntimeException{
	private String message="Address Id not found";
	public String getMessage() {
		return message;
	}
}
