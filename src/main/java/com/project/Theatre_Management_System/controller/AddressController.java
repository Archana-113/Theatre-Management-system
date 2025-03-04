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

import com.project.Theatre_Management_System.dto.Address;
import com.project.Theatre_Management_System.service.AddressService;
import com.project.Theatre_Management_System.util.ResponseStructure;
import com.project.Theatre_Management_System.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	@Operation(summary = "Save Address", description = "API is used to save the Address")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created")})
	
	@PostMapping("/saveAddress")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address)
	{
		return addressService.saveAddress(address);
	}
	
	@Operation(summary = " Fetch Address By Id ", description = "API is used to fetch Address")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully Address fetched "),
			@ApiResponse(responseCode = "404", description = "Address not found for the given id") })
	
	@GetMapping("/fetchAddressById")
	public ResponseEntity<ResponseStructure<Address>> fetchAddressById(@RequestParam int addressId)
	{
		return addressService.fetchAddressById(addressId)               ;
	}
	
	@Operation(summary = " Fetch All Address", description = "API is used to fetch all Addresses")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully all Addresses fetched ") })
	
	@GetMapping("/fetchAllAddress")
	public ResponseEntity<ResponseStructureList<Address>>  fetchAllAddress()
	{
		return addressService.fetchAllAddress();		
	}
	
	@Operation(summary = " Update Address By Id", description = "API is used to upadate the Address")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Address updated"),
			@ApiResponse(responseCode = "404", description = "Address not found for the given id") })
	
	@PutMapping("/updateAddressById")
	public ResponseEntity<ResponseStructure<Address>> updateAddressById(@RequestParam int oldAddressId,@RequestBody Address newAddress)
	{
		
		return addressService.updateAddressById(oldAddressId, newAddress);
	}
	
	@Operation(summary = " Delete Address By Id", description = "API is used to delete Address")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Address deleted"),
			@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })
	
	@DeleteMapping("/deleteAddressById")
	public ResponseEntity<ResponseStructure<Address>> deleteAddressById(@RequestParam int addressId)
	{
		return addressService.deleteAddressById(addressId);
	}

}
