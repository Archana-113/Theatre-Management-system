package com.project.Theatre_Management_System.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Theatre_Management_System.dto.Payment;
import com.project.Theatre_Management_System.service.PaymentService;
import com.project.Theatre_Management_System.util.ResponseStructure;
import com.project.Theatre_Management_System.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@Operation(summary = " Save Payment ", description = "API is used to save Payment")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Created ")})
	
	@PostMapping("/savePayment")
	public ResponseEntity<ResponseStructure<Payment>> savePayment(@RequestBody Payment payment)
	{
		return paymentService.savePayment(payment);
	}
	
	@Operation(summary = " Fetch Payment  ", description = "API is used to fetch Payment")
	@ApiResponses(value = { @ApiResponse(responseCode = "301", description = "Successfully Payment fetched "),
			@ApiResponse(responseCode = "404", description = "Payment not found for the given id") })
	
	@GetMapping("/fetchPaymentById")
	public ResponseEntity<ResponseStructure<Payment>> fetchPaymentById(@RequestParam int paymentId)
	{
		return paymentService.fetchPaymentById(paymentId);
		
	}
	
	@Operation(summary = " Fetch All Payments", description = "API is used to fetch all Payments")
	@ApiResponses(value = { @ApiResponse(responseCode = "301", description = "Successfully all Payments fetched ") })
	@GetMapping("/fetchAllPayment")
	public ResponseEntity<ResponseStructureList<Payment>> fetchAllPayment()
	{
		return paymentService.fetchAllPayment();
		
	}
	
	@Operation(summary = " Update Payment", description = "API is used to upadate the Payment")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Payment updated"),
			@ApiResponse(responseCode = "404", description = "Payment not found for the given id") })
	
	@PutMapping("/updatePaymentById")
	public ResponseEntity<ResponseStructure<Payment>> updatePaymentById(@RequestParam int oldPaymentId,@RequestBody Payment newPayment)
	{
		return paymentService.updatePaymentById(oldPaymentId, newPayment);
	}
	@Operation(summary = " Delete Payment", description = "API is used to delete Payment")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Payment deleted"),
			@ApiResponse(responseCode = "404", description = "Payment not found for the given id") })
	@DeleteMapping("/deletePaymentById")
	public ResponseEntity<ResponseStructure<Payment>> deletePaymentById(@RequestParam int paymentId)
	{
		return paymentService.deletePaymentById(paymentId);
	}
}
