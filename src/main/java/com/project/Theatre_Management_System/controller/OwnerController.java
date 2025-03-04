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

import com.project.Theatre_Management_System.dto.Owner;
import com.project.Theatre_Management_System.service.OwnerService;
import com.project.Theatre_Management_System.util.ResponseStructure;
import com.project.Theatre_Management_System.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


@RestController
public class OwnerController {
	
	@Autowired
	OwnerService ownerService;
	
	
	@Operation(summary = "Save Owner", description = "API is used to save the Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created")})
	
	@PostMapping("/saveOwner")
	public ResponseEntity<ResponseStructure<Owner>> saveOwner(@RequestBody Owner owner)
	{
		return ownerService.saveOwner(owner);
	}
	
	@Operation(summary = " Add Exixting Theatre To Existing Owner", description = "API is used to add Theatre to the Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Theatre Added to the Owner"),
			@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })
	
	@PutMapping("/addExixtingTheatreToExistingOwner")
	public ResponseEntity<ResponseStructure<Owner>> addExixtingTheatreToExistingOwner(@RequestParam int theatreId,@RequestParam int ownerId)
	{
		return ownerService.addExixtingTheatreToExistingOwner(theatreId, ownerId);
	}
	
	@Operation(summary = " Fetch Owner Based upon Id", description = "API is used to fetch the Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "301", description = "Successfully Owner fetched"),
			@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })
	
	@GetMapping("/fetchOwnerById")
	public ResponseEntity<ResponseStructure<Owner>> fetchOwnerById(@RequestParam int ownerId)
	{
		
		return ownerService.fetchOwnerById(ownerId) ;	
	}
	
	@Operation(summary = " Fetch All the Owners", description = "API is used to fetch all the Owners")
	@ApiResponses(value = { @ApiResponse(responseCode = "301", description = "Successfully Owners fetched"),
			@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })
	
	
	@GetMapping("/fetchAllOwner")
	public ResponseEntity<ResponseStructureList<Owner>> fetchAllOwner()
	{
		return ownerService.fetchAllOwner();
	}
	
	@Operation(summary = " Delete Owner", description = "API is used to delete Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Owner deleted"),
			@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })
	
	
	@DeleteMapping("/deleteOwnerById")
	public ResponseEntity<ResponseStructure<Owner>> deleteOwnerById(@RequestParam int ownerId)
	{
		return ownerService.deleteOwnerById(ownerId);
	}
	
	@Operation(summary = " Update Owner", description = "API is used to update the Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Owner updated"),
			@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })
	
	@PutMapping("/updateOwnerById")
	public ResponseEntity<ResponseStructure<Owner>> updateOwnerById(@RequestParam int oldOwnerId,@RequestBody Owner newOwner)
	{
		return ownerService.updateOwnerById(oldOwnerId, newOwner);
	}
}
