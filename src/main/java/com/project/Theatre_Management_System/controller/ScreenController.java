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

import com.project.Theatre_Management_System.dto.Screen;
import com.project.Theatre_Management_System.dto.Seat;
import com.project.Theatre_Management_System.service.ScreenService;
import com.project.Theatre_Management_System.util.ResponseStructure;
import com.project.Theatre_Management_System.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class ScreenController {
	
	@Autowired
	ScreenService screenService;
	
	@Operation(summary = " Save Screen", description = "API is used to save Screen")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Created ")})
	
	@PostMapping("/saveScreen")
	public ResponseEntity<ResponseStructure<Screen>> saveScreen(@RequestBody Screen Screen)
	{
		return screenService.saveScreen(Screen);
	}
	
	@Operation(summary = " toAdd Movie to Screen ", description = "API is used to add existing Movie to existing Screen")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Movie added to the Screen "),
			@ApiResponse(responseCode = "404", description = "Screen not found for the given id"),
			@ApiResponse(responseCode = "404", description = "movie not found for the given id")})
	
	@PutMapping("/addExistingMovieToExistingScreen")
	public ResponseEntity<ResponseStructure<Screen>> addExistingMovieToExistingScreen(@RequestParam int movieId,@RequestParam int screenId)
	{
		return screenService.addExistingMovieToExistingScreen(movieId, screenId);
	}
	
	@Operation(summary = " toAdd Seat to Screen ", description = "API is used to add existing Seat to existing Screen")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Seat added to the Screen "),
			@ApiResponse(responseCode = "404", description = "Screen not found for the given id"),
			@ApiResponse(responseCode = "404", description = "Seat not found for the given id")})
	
	@PutMapping("/addExistingSeatToExistingScreen")
	public ResponseEntity<ResponseStructure<Screen>> addExistingSeatToExistingScreen(@RequestParam int seatId,@RequestParam int screenId)
	{
		return screenService.addExistingSeatToExistingScreen(seatId, screenId);
	}
	
	@Operation(summary = " toAdd  newSeat to Screen ", description = "API is used to add newSeat to existing Screen")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully newSeat added to the Screen "),
			@ApiResponse(responseCode = "404", description = "Screen not found for the given id") })
	
	@PutMapping("/addNewSeatToExistingScreen")
	public ResponseEntity<ResponseStructure<Screen>> addNewSeatToExistingScreen(@RequestParam int screenId, @RequestBody Seat newSeat)
	{
		return screenService.addNewSeatToExistingScreen(screenId, newSeat);
	}

	@Operation(summary = " Fetch Screen ", description = "API is used to fetch Screen")
	@ApiResponses(value = { @ApiResponse(responseCode = "301", description = "Successfully Screen fetched "),
			@ApiResponse(responseCode = "404", description = "Screen not found for the given id") })
	@GetMapping("/fetchScreenById")
	public ResponseEntity<ResponseStructure<Screen>> fetchScreenById(@RequestParam int screenId)
	{
		return screenService.fetchScreenById(screenId);
		
	}
	@Operation(summary = " Fetch All Screens", description = "API is used to fetch all Screens")
	@ApiResponses(value = { @ApiResponse(responseCode = "301", description = "Successfully all Screens fetched ") })
	
	@GetMapping("/fetchAllScreen")
	public ResponseEntity<ResponseStructureList<Screen>> fetchAllScreen()
	{
		return screenService.fetchAllScreen();	
	}
	
	@Operation(summary = " Update Screen", description = "API is used to upadate the Screen")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Screen updated"),
			@ApiResponse(responseCode = "404", description = "Screen not found for the given id") })
	@PutMapping("/updateScreenById")
	public ResponseEntity<ResponseStructure<Screen>> updateScreenById(@RequestParam int oldScreenId,@RequestBody Screen newScreen)
	{
		
		return screenService.updateScreenById(oldScreenId, newScreen);
	}
	
	@Operation(summary = " Delete Screen", description = "API is used to delete Screen")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Screen deleted"),
			@ApiResponse(responseCode = "404", description = "Screen not found for the given id") })
	@DeleteMapping("/deleteScreenById")
	public ResponseEntity<ResponseStructure<Screen>> deleteScreenById(@RequestParam int screenId)
	{
		return screenService.deleteScreenById(screenId);
	}

}
