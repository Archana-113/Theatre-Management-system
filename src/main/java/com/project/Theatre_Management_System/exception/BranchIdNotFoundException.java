package com.project.Theatre_Management_System.exception;

public class BranchIdNotFoundException extends RuntimeException {
	private String message="Branch Id not found";

	public String getMessage() {
		return message;
	}

}
