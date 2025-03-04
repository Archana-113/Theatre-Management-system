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

import com.project.Theatre_Management_System.dto.Ticket;
import com.project.Theatre_Management_System.service.TicketService;
import com.project.Theatre_Management_System.util.ResponseStructure;
import com.project.Theatre_Management_System.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class TicketController {
	@Autowired
	TicketService ticketService;
	
	@Operation(summary = " Save Ticket", description = "API is used to save Ticket")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Created ")})
	
	@PostMapping("/saveTicket")
	public ResponseEntity<ResponseStructure<Ticket>> saveticket(@RequestBody Ticket ticket)
	{
		return ticketService.saveTicket(ticket);
	}

	@Operation(summary = " toAdd Payment To Ticket ", description = "API is used to add Payment to Theatre")
	@ApiResponses(value = { @ApiResponse(responseCode = "301", description = "Successfully Payment added to Ticket "),
			@ApiResponse(responseCode = "404", description = "Ticket not found for the given id"),
			@ApiResponse(responseCode = "404", description = "Payment not found for the given id")})
		
	@PutMapping("/addExistingPaymentToExistingTicket")
	public ResponseEntity<ResponseStructure<Ticket>> addExistingPaymentToExistingTicket(@RequestParam int paymentId,@RequestParam int ticketId)
	{
		return ticketService.addExistingPaymentToExistingTicket(paymentId, ticketId);
	}
	

	@Operation(summary = " Fetch Ticket ", description = "API is used to fetch Ticket")
	@ApiResponses(value = { @ApiResponse(responseCode = "301", description = "Successfully Ticket fetched "),
			@ApiResponse(responseCode = "404", description = "Ticket not found for the given id") })
	
	@GetMapping("/fetchTicketById")
	public ResponseEntity<ResponseStructure<Ticket>> fetchticketById(@RequestParam int ticketId)
	{
		return ticketService.fetchticketById(ticketId);
	}
	
	@Operation(summary = " Fetch All Ticket", description = "API is used to fetch all Ticket")
	@ApiResponses(value = { @ApiResponse(responseCode = "301", description = "Successfully all Tciket fetched ") })
	
	@GetMapping("/fetchAllTicket")
	public ResponseEntity<ResponseStructureList<Ticket>> fetchAllTicket()
	{
		return ticketService.fetchAllTicket();		
	}
	
	@Operation(summary = " Update Ticket", description = "API is used to upadate the Ticket")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Ticket updated"),
			@ApiResponse(responseCode = "404", description = "Ticket not found for the given id") })
	
	@PutMapping("/updateTicketById")
	public ResponseEntity<ResponseStructure<Ticket>> updateTicketById(@RequestParam int oldTicketId,@RequestBody Ticket newTicket)
	{	
		return ticketService.updateTicketById(oldTicketId, newTicket);
	}
	
	@Operation(summary = " Delete Ticket", description = "API is used to delete Ticket")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Ticket deleted"),
			@ApiResponse(responseCode = "404", description = "Ticket not found for the given id") })

	@DeleteMapping("/deleteTicketById")
	public ResponseEntity<ResponseStructure<Ticket>> deleteTicketById(@RequestParam int ticketId)
	{
		return ticketService.deleteTicketById(ticketId);
	}

}
