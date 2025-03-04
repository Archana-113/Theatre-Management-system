package com.project.Theatre_Management_System.exception;

public class StaffIdNotFoundException extends RuntimeException{
	private String message="Staff Id not found";

	public String getMessage() {
		return message;
	}

}
