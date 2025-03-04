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

import com.project.Theatre_Management_System.dto.Branch;
import com.project.Theatre_Management_System.dto.Theatre;
import com.project.Theatre_Management_System.service.TheatreService;
import com.project.Theatre_Management_System.util.ResponseStructure;
import com.project.Theatre_Management_System.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class TheatreController {
	
	@Autowired
	TheatreService theatreService;
	
	@Operation(summary = " Save Theatre", description = "API is used to save Theatre")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Created ")})
	
	@PostMapping("/saveTheatre")
	public ResponseEntity<ResponseStructure<Theatre>> saveTheatre(@RequestBody Theatre theatre)
	{
		return theatreService.saveTheatre(theatre);
	}
	@Operation(summary = " toAdd Branch To Theatre ", description = "API is used to fetch Theatre")
	@ApiResponses(value = { @ApiResponse(responseCode = "301", description = "Successfully Branch added to Theatre "),
			@ApiResponse(responseCode = "404", description = "Theatre not found for the given id"),
			@ApiResponse(responseCode = "404", description = "Branch not found for the given id")})
	
	@PutMapping("/addExistingBranchToExistingTheatre")
	public ResponseEntity<ResponseStructure<Theatre>> addExistingBranchToExistingTheatre(@RequestParam int branchId,@RequestParam int theatreId)
	{
		return theatreService.addExistingBranchToExistingTheatre(branchId, theatreId);
	}
	
	@Operation(summary = " toAdd newBranch To Theatre ", description = "API is used to add Branch to Screen")
	@ApiResponses(value = { @ApiResponse(responseCode = "301", description = "Successfully Branch added to Theatre "),
			@ApiResponse(responseCode = "404", description = "Theatre not found for the given id")})
	
	@PutMapping("/addNewBranchToExistingTheatre")
	public ResponseEntity<ResponseStructure<Theatre>> addNewBranchToExistingTheatre(@RequestParam int theatreId,@RequestBody Branch newBranch)
	{
		return theatreService.addNewBranchToExistingTheatre(theatreId, newBranch);
	}
	@Operation(summary = " Fetch Theatre ", description = "API is used to fetch Theatre")
	@ApiResponses(value = { @ApiResponse(responseCode = "301", description = "Successfully Theatre fetched "),
			@ApiResponse(responseCode = "404", description = "Theatre not found for the given id") })
	
	@GetMapping("/fetchTheatreById")
	public ResponseEntity<ResponseStructure<Theatre>> fetchTheatreById(@RequestParam int theatreId)
	{
		return theatreService.fetchTheatreById(theatreId);
	}
	
	@Operation(summary = " Fetch All Theatres", description = "API is used to fetch all Theatres")
	@ApiResponses(value = { @ApiResponse(responseCode = "301", description = "Successfully all Theatres fetched ") })
	
	@GetMapping("/fetchAllTheatre")
	public ResponseEntity<ResponseStructureList<Theatre>> fetchAllTheatre()
	{
		return theatreService.fetchAllTheatre();		
	}
	
	@Operation(summary = " Update Theatre", description = "API is used to upadate the Theatre")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Theatre updated"),
			@ApiResponse(responseCode = "404", description = "Theatre not found for the given id") })
	
	
	@PutMapping("/updateTheatreById")
	public ResponseEntity<ResponseStructure<Theatre>> updateTheatreById(@RequestParam int oldTheatreId,@RequestBody Theatre newTheatre)
	{
		return theatreService.updateTheatreById(oldTheatreId, newTheatre);
	}
	
	@Operation(summary = " Delete Theatre", description = "API is used to delete Theatre")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Theatre deleted"),
			@ApiResponse(responseCode = "404", description = "Theatre not found for the given id") })
	
	
	@DeleteMapping("/deleteTheatreById")
	public ResponseEntity<ResponseStructure<Theatre>> deleteTheatreById(@RequestParam int theatreId)
	{
		
		return theatreService.deleteTheatreById(theatreId);
	}


}
