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

import com.project.Theatre_Management_System.dto.Review;
import com.project.Theatre_Management_System.service.ReviewService;
import com.project.Theatre_Management_System.util.ResponseStructure;
import com.project.Theatre_Management_System.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class ReviewController {
	@Autowired
	ReviewService reviewService;
	
	@Operation(summary = " Save Review ", description = "API is used to save Review")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Created ")})
	
	@PostMapping("/saveReview")
	public ResponseEntity<ResponseStructure<Review>> saveReview(@RequestBody Review review)
	{
		return reviewService.saveReview(review);
	}
	
	@Operation(summary = " Fetch Review  ", description = "API is used to fetch Review")
	@ApiResponses(value = { @ApiResponse(responseCode = "301", description = "Successfully Review fetched "),
			@ApiResponse(responseCode = "404", description = "Review not found for the given id") })
	@GetMapping("/fetchReviewById")
	public ResponseEntity<ResponseStructure<Review>> fetchReviewById(@RequestParam int reviewId)
	{	
		return reviewService.fetchReviewById(reviewId);	
	}
	
	@Operation(summary = " Fetch All Reviews", description = "API is used to fetch all Reviews")
	@ApiResponses(value = { @ApiResponse(responseCode = "301", description = "Successfully all Reviews fetched ") })
	
	@GetMapping("/fetchAllReview")
	public ResponseEntity<ResponseStructureList<Review>> fetchAllReview()
	{
		return reviewService.fetchAllReview();
	}
	
	@Operation(summary = " Update Review", description = "API is used to upadate the Review")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Review updated"),
			@ApiResponse(responseCode = "404", description = "Review not found for the given id") })
	
	@PutMapping("/updateReviewById")
	public ResponseEntity<ResponseStructure<Review>> updateReviewById(@RequestParam int oldReviewId,@RequestBody Review newReview)
	{
		return reviewService.updateReviewById(oldReviewId, newReview);
	}
	@Operation(summary = " Delete Review", description = "API is used to delete Review")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Review deleted"),
			@ApiResponse(responseCode = "404", description = "Review not found for the given id") })
	
	@DeleteMapping("/deleteReviewById")
	public ResponseEntity<ResponseStructure<Review>> deleteReviewById(@RequestParam int reviewId)
	{
		return reviewService.deleteReviewById(reviewId);
	}

}
