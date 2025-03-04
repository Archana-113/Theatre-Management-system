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

import com.project.Theatre_Management_System.dto.Manager;
import com.project.Theatre_Management_System.service.ManagerService;
import com.project.Theatre_Management_System.util.ResponseStructure;
import com.project.Theatre_Management_System.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class ManagerController {
	
	@Autowired
	 ManagerService managerService;
	
	@Operation(summary = " Save Manager ", description = "API is used to save Manager")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Created ") })

	@PostMapping("/saveManager")
	public ResponseEntity<ResponseStructure<Manager>> saveManager(@RequestBody Manager manager)
	{
		return managerService.saveManager(manager);
	}
	
	@Operation(summary = " Fetch Manager ", description = "API is used to fetch Manager by id")
	@ApiResponses(value = { @ApiResponse(responseCode = "301", description = "Successfully Manger fetched "),
			@ApiResponse(responseCode = "404", description = "Manager not found for the given id") })
	
	@GetMapping("/fetchManagerById")
	public ResponseEntity<ResponseStructure<Manager>> fetchManagerById(@RequestParam int managerId)
	{
		
		return managerService.fetchMangerById(managerId);
	}
	
	@Operation(summary = " Fetch All Managers ", description = "API is used to fetch all Managers")
	@ApiResponses(value = { @ApiResponse(responseCode = "301", description = "Successfully all Managers fetched ") })
	
	@GetMapping("/fetchAllManager")
	public ResponseEntity<ResponseStructureList<Manager>> fetchAllManager()
	{
		return managerService.fetchAllManager();		
	}
	
	@Operation(summary = " Upadate Branch ", description = "API is used to upadte Manger by id")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Manager updated "),
			@ApiResponse(responseCode = "404", description = "Manager not found for the given id") })
	
	@PutMapping("/updateManagerById")
	public ResponseEntity<ResponseStructure<Manager>> updateManagerById(@RequestParam int oldManagerId,@RequestBody Manager newManager)
	{
		return managerService.updateManagerById(oldManagerId, newManager);
	}
	
	@Operation(summary = " Delete Manager ", description = "API is used to delete Manager by id")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Manager deleted "),
			@ApiResponse(responseCode = "404", description = "Manager not found for the given id") })
	
	@DeleteMapping("/deleteManagerById")
	public ResponseEntity<ResponseStructure<Manager>> deleteManagerById(@RequestParam int managerId)
	{
		return managerService.deleteManagerById(managerId);
	}

}
