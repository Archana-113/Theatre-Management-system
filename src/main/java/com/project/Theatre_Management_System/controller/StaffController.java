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

import com.project.Theatre_Management_System.dto.Staff;
import com.project.Theatre_Management_System.service.StaffService;
import com.project.Theatre_Management_System.util.ResponseStructure;
import com.project.Theatre_Management_System.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class StaffController {
	
	@Autowired
	StaffService staffService;
	
	@Operation(summary = " Save Staff", description = "API is used to save Staff")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Created ")})
	
	@PostMapping("/saveStaff")
	public ResponseEntity<ResponseStructure<Staff>> saveStaff(@RequestBody Staff staff)
	{
		return staffService.saveStaff(staff);
	}
	
	@Operation(summary = " Fetch Staff ", description = "API is used to fetch Staff")
	@ApiResponses(value = { @ApiResponse(responseCode = "301", description = "Successfully Staff fetched "),
			@ApiResponse(responseCode = "404", description = "Staff not found for the given id") })
	
	@GetMapping("/fetchStaffById")
	public ResponseEntity<ResponseStructure<Staff>> fetchStaffById(@RequestParam int staffId)
	{
		return staffService.fetchStaffById(staffId);
	}
	
	@Operation(summary = " Fetch All Staffs", description = "API is used to fetch all Staffs")
	@ApiResponses(value = { @ApiResponse(responseCode = "301", description = "Successfully all Staffs fetched ") })
	
	@GetMapping("/fetchAllStaff")
	public ResponseEntity<ResponseStructureList<Staff>> fetchAllStaff()
	{
		return staffService.fetchAllStaff();
	}
	
	@Operation(summary = " Update Staff", description = "API is used to upadate the Staff")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Staff updated"),
			@ApiResponse(responseCode = "404", description = "Staff not found for the given id") })
	
	@PutMapping("/updateStaffById")
	public ResponseEntity<ResponseStructure<Staff>> updateStaffById(@RequestParam int oldStaffId,@RequestBody Staff newStaff)
	{
		
		return staffService.updateStaffById(oldStaffId, newStaff) ;
	}
	
	@Operation(summary = " Delete Staff", description = "API is used to delete Staff")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Staff deleted"),
			@ApiResponse(responseCode = "404", description = "Staff not found for the given id") })
	
	@DeleteMapping("/deleteStaffById")
	public ResponseEntity<ResponseStructure<Staff>> deleteStaffById(@RequestParam int staffId)
	{	
		return staffService.deleteStaffById(staffId);
	}
}
