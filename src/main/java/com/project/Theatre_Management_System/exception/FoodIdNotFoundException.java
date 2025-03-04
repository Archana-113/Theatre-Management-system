package com.project.Theatre_Management_System.exception;

public class FoodIdNotFoundException extends RuntimeException {
	private String message="Food Id not found";

	public String getMessage() {
		return message;
	}

}
