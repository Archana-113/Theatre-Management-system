package com.project.Theatre_Management_System.exception;

public class ViewerIdNotFoundException extends RuntimeException{
	private String message="Viewer Id not found";
	public String getMessage() {
		return message;
	}

}
