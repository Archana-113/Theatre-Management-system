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

import com.project.Theatre_Management_System.dto.Seat;
import com.project.Theatre_Management_System.service.SeatService;
import com.project.Theatre_Management_System.util.ResponseStructure;
import com.project.Theatre_Management_System.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class SeatContoller {

	@Autowired
	SeatService seatService;
	
	@Operation(summary = " Save Seat", description = "API is used to save Seat")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Created ")})
	
	
	@PostMapping("/saveSeat")
	public ResponseEntity<ResponseStructure<Seat>> saveSeat(@RequestBody Seat seat)
	{
		return seatService.saveSeat(seat);
	}
	
	@Operation(summary = " toAdd Viewer to Seat ", description = "API is used to add existing Viewer to existing Seat")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Viewer added to the Seat "),
			@ApiResponse(responseCode = "404", description = "Seat not found for the given id"),
			@ApiResponse(responseCode = "404", description = "Viewer not found for the given id")})
	
	@PutMapping("/addExistingViewerToExistingSeat")
	public ResponseEntity<ResponseStructure<Seat>> addExistingViewerToExistingSeat(@RequestParam int viewerId,@RequestParam int seatId)
	{
		return seatService.addExistingViewerToExistingSeat(viewerId, seatId);
	}
	
	@Operation(summary = " Fetch Seat ", description = "API is used to fetch Seat")
	@ApiResponses(value = { @ApiResponse(responseCode = "301", description = "Successfully Seat fetched "),
			@ApiResponse(responseCode = "404", description = "Seat not found for the given id") })
	
	@GetMapping("/fetchSeatById")
	public ResponseEntity<ResponseStructure<Seat>> fetchSeatById(@RequestParam int seatId)
	{
		return seatService.fetchSeatById(seatId);	
	}
	
	@Operation(summary = " Fetch All Seats", description = "API is used to fetch all Seats")
	@ApiResponses(value = { @ApiResponse(responseCode = "301", description = "Successfully all Seats fetched ") })
	
	@GetMapping("/fetchAllSeat")
	public ResponseEntity<ResponseStructureList<Seat>> fetchAllSeat()
	{
		return seatService.fetchAllSeat();	
	}
	
	@Operation(summary = " Update Seat", description = "API is used to upadate the Seat")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Seat updated"),
			@ApiResponse(responseCode = "404", description = "Seat not found for the given id") })
	
	@PutMapping("/updateSeatById")
	public ResponseEntity<ResponseStructure<Seat>> updateSeatById(@RequestParam int oldSeatId,@RequestBody Seat newSeat)
	{
		return seatService.updateSeatById(oldSeatId, newSeat);
	}
	
	@Operation(summary = " Delete Seat", description = "API is used to delete Seat")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Seat deleted"),
			@ApiResponse(responseCode = "404", description = "Seat not found for the given id") })
	
	@DeleteMapping("/deleteSeatById")
	public ResponseEntity<ResponseStructure<Seat>> deleteSeatById(@RequestParam int seatId)
	{
		return seatService.deleteSeatById(seatId);
	}
}
