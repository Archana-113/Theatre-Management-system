package com.project.Theatre_Management_System.exception;

public class PaymentIdNotFoundException  extends RuntimeException{
	private String message="Payment Id not found";

	public String getMessage() {
		return message;
	}

}
