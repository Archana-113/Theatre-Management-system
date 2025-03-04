package com.project.Theatre_Management_System.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.Theatre_Management_System.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	@Autowired
	ResponseStructure<String> responseStructure;
	
	@ExceptionHandler(OwnerIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>>  ownerIdNotFound(OwnerIdNotFoundException ownerIdNotFoundException)
	{
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Owner is not present in the DB");
		responseStructure.setData(ownerIdNotFoundException.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND) ;
	}
	@ExceptionHandler(TheatreIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> theatreIdNotFound(TheatreIdNotFoundException theatreIdNotFoundException)
	{
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Theatre is not present in the DB");
		responseStructure.setData(theatreIdNotFoundException.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND) ;
	}
	
	@ExceptionHandler(BranchIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> branchIdNotFound(BranchIdNotFoundException branchIdNotFoundException)
	{
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Branch is not present in the DB");
		responseStructure.setData(branchIdNotFoundException.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND) ;
	}
	
	@ExceptionHandler(ManagerIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> managerIdNotFound(ManagerIdNotFoundException managerIdNotFoundException)
	{
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Manager is not present in the DB");
		responseStructure.setData(managerIdNotFoundException.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND) ;
	}
	
	@ExceptionHandler(AddressIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> AddressIdNotFound(AddressIdNotFoundException addressIdNotFoundException)
	{
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Address is not present in the DB");
		responseStructure.setData(addressIdNotFoundException.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND) ;
	}
	
	@ExceptionHandler(StaffIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> SatffIdNotFound(StaffIdNotFoundException staffIdNotFoundException)
	{
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Staff is not present in the DB");
		responseStructure.setData(staffIdNotFoundException.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND) ;
	}
	
	@ExceptionHandler(ScreenIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> ScreenIdNotFound(ScreenIdNotFoundException screenIdNotFoundException)
	{
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Screen is not present in the DB");
		responseStructure.setData(screenIdNotFoundException.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND) ;
	}
	
	@ExceptionHandler(FoodIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> FoodIdNotFound(FoodIdNotFoundException foodIdNotFoundException)
	{
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Food is not present in the DB");
		responseStructure.setData(foodIdNotFoundException.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND) ;
	}
	
	@ExceptionHandler(MovieIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> movieIdNotFound(MovieIdNotFoundException movieIdNotFoundException)
	{
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Movie is not present in the DB");
		responseStructure.setData(movieIdNotFoundException.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND) ;
	}
	
	@ExceptionHandler(PaymentIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> paymentIdNotFound(PaymentIdNotFoundException paymentIdNotFoundException)
	{
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Payment is not present in the DB");
		responseStructure.setData(paymentIdNotFoundException.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND) ;
	}
	@ExceptionHandler(TicketIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> ticketIdNotFound(TicketIdNotFoundException ticketIdNotFoundException)
	{
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Ticket is not present in the DB");
		responseStructure.setData(ticketIdNotFoundException.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND) ;
	}
	
	@ExceptionHandler(ViewerIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> viewerIdNotFound(ViewerIdNotFoundException viewerIdNotFoundException)
	{
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Viewer is not present in the DB");
		responseStructure.setData(viewerIdNotFoundException.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND) ;
	}
	
	@ExceptionHandler(ReviewIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> reviewIdNotFound(ReviewIdNotFoundException reviewIdNotFoundException)
	{
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Review is not present in the DB");
		responseStructure.setData(reviewIdNotFoundException.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND) ;
	}
	
	@ExceptionHandler(SeatIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> seatIdNotFound(SeatIdNotFoundException seatIdNotFoundException)
	{
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Seat is not present in the DB");
		responseStructure.setData(seatIdNotFoundException.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND) ;
	}
}
