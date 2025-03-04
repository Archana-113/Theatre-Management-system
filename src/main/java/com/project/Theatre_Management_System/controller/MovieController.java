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

import com.project.Theatre_Management_System.dto.Movie;
import com.project.Theatre_Management_System.dto.Review;
import com.project.Theatre_Management_System.dto.Viewer;
import com.project.Theatre_Management_System.service.MovieService;
import com.project.Theatre_Management_System.util.ResponseStructure;
import com.project.Theatre_Management_System.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	@Operation(summary = " Save Movie ", description = "API is used to save Movie")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Created ")})
	
	@PostMapping("/saveMovie")
	public ResponseEntity<ResponseStructure<Movie>> saveMovie(@RequestBody Movie movie)
	{
		return movieService.saveMovie(movie);
	}
	
	@Operation(summary = " toAdd Viewer To  Movie ", description = "API is used to add existing Viewer to existing Movie")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Viewer is added to the Movie"),
			@ApiResponse(responseCode = "404", description = "Movie not found for the given id"),
			@ApiResponse(responseCode = "404", description = "Viewer not found for the given id")})
	
	@PutMapping("/addExistingViewerToExistingMovie")
	public ResponseEntity<ResponseStructure<Movie>> addExistingViewerToExistingMovie(@RequestParam int viewerId,@RequestParam int movieId)
	{
		return movieService.addExistingViewerToExistingMovie(viewerId, movieId);
	}
	
	@Operation(summary = " toAdd new Viewer To  Movie ", description = "API is used to add existing Viewer to existing Movie")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully new Viewer is added to the Movie"),
			@ApiResponse(responseCode = "404", description = "Movie not found for the given id")})
	
	@PutMapping("/addNewViewerToExistingMovie")
	public ResponseEntity<ResponseStructure<Movie>> addNewViewerToExistingMovie(@RequestParam int movieId,@RequestBody Viewer newViewer)
	{
		return movieService.addNewViewerToExistingMovie(movieId, newViewer);
	}
	
	@Operation(summary = " toAdd Review To  Movie ", description = "API is used to add existing Review to existing Movie")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Review is added to the Movie"),
			@ApiResponse(responseCode = "404", description = "Movie not found for the given id"),
			@ApiResponse(responseCode = "404", description = "Review not found for the given id")})
	@PutMapping("/addExistingReviewToExistingMovie")
	public ResponseEntity<ResponseStructure<Movie>> addExistingReviewToExistingMovie(@RequestParam int reviewId,@RequestParam int movieId)
	{
		return movieService.addExistingReviewToExistingMovie(reviewId, movieId);
	}
	
	@Operation(summary = " toAdd new Review To  Movie ", description = "API is used to add new Review to existing Movie")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully new Review is added to the Movie"),
			@ApiResponse(responseCode = "404", description = "Movie not found for the given id")})
	
	@PutMapping("/addNewReviewToExistingMovie")
	public ResponseEntity<ResponseStructure<Movie>> addNewReviewToExistingMovie(@RequestParam int movieId,@RequestBody Review newReview)
	{
		return movieService.addNewReviewToExistingMovie(movieId, newReview);
	}
	
	@Operation(summary = " Fetch Movie ", description = "API is used to fetch Movie by id")
	@ApiResponses(value = { @ApiResponse(responseCode = "301", description = "Successfully Movie fetched "),
			@ApiResponse(responseCode = "404", description = "Movie not found for the given id") })
	
	@GetMapping("/fetchMovieById")
	public ResponseEntity<ResponseStructure<Movie>> fetchMovieById(@RequestParam int movieId)
	{
		return movieService.fetchMovieById(movieId);
	}
	@Operation(summary = " Fetch All Movies ", description = "API is used to fetch All Movies")
	@ApiResponses(value = { @ApiResponse(responseCode = "301", description = "Successfully all Movies fetched ") })
	
	@GetMapping("/fetchAllMovie")
	public ResponseEntity<ResponseStructureList<Movie>> fetchAllMovie()
	{
		return movieService.fetchAllMovie();		
	}
	
	@Operation(summary = " Update Movie ", description = "API is used to Upadte Movie By id")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Movie Updated"),
			@ApiResponse(responseCode = "404", description = "Movie not found for the given id")})
	
	@PutMapping("/updateMovieById")
	public ResponseEntity<ResponseStructure<Movie>> updateMovieById(@RequestParam int oldMovieId,@RequestBody Movie newMovie)
	{
		return movieService.updateMovieById(oldMovieId, newMovie);	
	}
	
	@Operation(summary = " Delete Movie ", description = "API is used to Delete Movie By id")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Movie deleted"),
			@ApiResponse(responseCode = "404", description = "Movie not found for the given id")})
	
	@DeleteMapping("/deleteMovieById")
	public ResponseEntity<ResponseStructure<Movie>> deleteMovieById(@RequestParam int movieId)
	{
		return movieService.deleteMovieById(movieId);
	}
	

}
