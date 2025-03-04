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
import com.project.Theatre_Management_System.dto.Screen;
import com.project.Theatre_Management_System.dto.Staff;
import com.project.Theatre_Management_System.service.BranchService;
import com.project.Theatre_Management_System.util.ResponseStructure;
import com.project.Theatre_Management_System.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class BranchController {
	
	@Autowired
	BranchService branchService;
	
	@Operation(summary = "Save Branch", description = "API is used to save Branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created")})
	
	
	@PostMapping("/saveBranch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch)
	{
		return branchService.saveBranch(branch);
	}
	
	@Operation(summary = " toAdd Manager To Branch ", description = "API is used to add exsting Manager to existing Branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Manager added to the Branch "),
			@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })
	
	@PutMapping("/addExistingManagerToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addExistingManagerToExistingBranch(@RequestParam int managerId,@RequestParam int branchId) {
		return branchService.addExistingManagerToExistingBranch(managerId, branchId);
	}
	
	@Operation(summary = " toAdd Address To  Branch ", description = "API is used to add existing Address to existing Branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Address is added to the Branch"),
			@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })
	
	@PutMapping("/addExistingAddressToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addExistingAddressToExistingBranch(@RequestParam int addressId,@RequestParam int branchId)
	{
		return branchService.addExistingAddressToExistingBranch(addressId, branchId);
	}
	
	@Operation(summary = " toAdd Staff To  Branch ", description = "API is used to add existing Staff to existing Branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully staff is added to the Branch"),
			@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })
	
	@PutMapping("/addExistingStaffToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addExistingStaffToExistingBranch(@RequestParam int staffId,@RequestParam int branchId) {
		return branchService.addExistingStaffToExistingBranch(staffId, branchId);
	}
	
	@Operation(summary = " toAdd New Staff To Branch", description = "API is used to add new Staff to Existing Branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully new Staff is added to the Branch  "),
			@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })
	
	@PutMapping("/addNewStaffToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addNewStaffToExistingBranch(@RequestParam int branchId,@RequestBody Staff newStaff)
	{
		return branchService.addNewStaffToExistingBranch(branchId, newStaff);
	}
	
	@Operation(summary = " toAdd Screen To  Branch ", description = "API is used to add existing Screen to existing Branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Screeb is added to the Branch"),
			@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })
	
	@PutMapping("/addExistingScreenToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addExistingScreenToExistingBranch(@RequestParam int screenId,@RequestParam int branchId)
	{
		return branchService.addExistingScreenToExistingBranch(screenId, branchId);
	}
	
	@Operation(summary = " toAdd New Screen To Branch", description = "API is used to add new Screen to Existing Branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully new Screen is added to the Branch  "),
			@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })
	
	@PutMapping("/addNewScreenToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addNewScreenToExistingBranch(@RequestParam int branchId,@RequestBody Screen newScreen)
	{
		return branchService.addNewScreenToExistingBranch(branchId, newScreen);
	}
	
	@Operation(summary = " Fetch Branch By Id ", description = "API is used to fetch Branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "301", description = "Successfully Branch fetched "),
			@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })
	
	@GetMapping("/fetchBranchById")
	public ResponseEntity<ResponseStructure<Branch>> fetchBranchById(@RequestParam int branchId)
	{
		return branchService.fetchBranchById(branchId);
	}
	
	@Operation(summary = " Fetch All Branches ", description = "API is used to  fetch all Branches")
	@ApiResponses(value = { @ApiResponse(responseCode = "301", description = "Successfully all Branches fetched ") })
	
	@GetMapping("/fetchAllBranch")
	public ResponseEntity<ResponseStructureList<Branch>> fetchAllBranch()
	{
		return branchService.fetchAllBranch();
	}
	
	@Operation(summary = " Upadate Branch ", description = "API is used to upadte Branch by id")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Branch updated "),
			@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })
	
	@PutMapping("/updateBranchById")
	public ResponseEntity<ResponseStructure<Branch>> updateBranchById(@RequestParam int oldBranchId,@RequestBody Branch newBranch)
	{
		return branchService.updateBranchById(oldBranchId, newBranch);
	}
	
	@Operation(summary = " Delete Branch ", description = "API is used to delete Branch by Id")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  "),
			@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })
	
	@DeleteMapping("/deleteBranchById")
	public ResponseEntity<ResponseStructure<Branch>> deletBranchById(@RequestParam int branchId)
	{
		return branchService.deleteBranchById(branchId);
	}

}
