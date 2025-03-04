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

import com.project.Theatre_Management_System.dto.Food;
import com.project.Theatre_Management_System.service.FoodService;
import com.project.Theatre_Management_System.util.ResponseStructure;
import com.project.Theatre_Management_System.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class FoodController {
	@Autowired
	FoodService foodService;
	
	@Operation(summary = "Save Food", description = "API is used to save Food")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created")})
	
	@PostMapping("/saveFood")
	public ResponseEntity<ResponseStructure<Food>> saveFood(@RequestBody Food food)
	{
		return foodService.saveFood(food);
	}
	
	@Operation(summary = " Fetch Food", description = "API is used to fetch Food")
	@ApiResponses(value = { @ApiResponse(responseCode = "301", description = "Successfully Food fetched "),
			@ApiResponse(responseCode = "404", description = "Food not found for the given id") })
	
	@GetMapping("/fetchFoodById")
	public ResponseEntity<ResponseStructure<Food>> fetchFoodById(@RequestParam int foodId)
	{
		return foodService.fetchFoodById(foodId);	
	}
	
	@Operation(summary = " Fetch All Foods ", description = "API is used to fetch Foods")
	@ApiResponses(value = { @ApiResponse(responseCode = "301", description = "Successfully all Food fetched ") })
	
	@GetMapping("/fetchAllFood")
	public ResponseEntity<ResponseStructureList<Food>> fetchAllFood()
	{
		return foodService.fetchAllFood();	
	}
	
	@Operation(summary = " Upadate Food ", description = "API is used to upadte Food by id")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Food updated "),
			@ApiResponse(responseCode = "404", description = "Food not found for the given id") })
	
	@PutMapping("/updateFoodById")
	public ResponseEntity<ResponseStructure<Food>> updateFoodById(@RequestParam int oldFoodId,@RequestBody Food newFood)
	{
		return foodService.updateFoodById(oldFoodId, newFood);
	}
	
	@Operation(summary = " Delete Food ", description = "API is used to delete Food by id")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Food deleted "),
			@ApiResponse(responseCode = "404", description = "Food not found for the given id") })
	
	@DeleteMapping("/deleteFoodById")
	public ResponseEntity<ResponseStructure<Food>> deleteFoodById(@RequestParam int foodId)
	{
		return foodService.deleteFoodById(foodId);
	}

}
