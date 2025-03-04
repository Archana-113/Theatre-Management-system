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
import com.project.Theatre_Management_System.dto.Ticket;
import com.project.Theatre_Management_System.dto.Viewer;
import com.project.Theatre_Management_System.service.ViewerService;
import com.project.Theatre_Management_System.util.ResponseStructure;
import com.project.Theatre_Management_System.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class ViewerController {
	@Autowired
	ViewerService viewerService;
	
	
	@Operation(summary = " Save Viewer", description = "API is used to save Viewer")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Created ")})
	@PostMapping("/saveViewer")
	public ResponseEntity<ResponseStructure<Viewer>> saveViewer(@RequestBody Viewer viewer)
	{
		return viewerService.saveViewer(viewer);
	}
	
	@Operation(summary = " toAdd Food to Viewer ", description = "API is used to add existing Food to existing Viewer")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Food added to the Viewer "),
			@ApiResponse(responseCode = "404", description = "Viewer not found for the given id"),
			@ApiResponse(responseCode = "404", description = "Food not found for the given id")})
	
	@PutMapping("/addExistingFoodToExistingViewer")
	public ResponseEntity<ResponseStructure<Viewer>> addExistingFoodToExistingViewer(@RequestParam int foodId,@RequestParam int viewerId)
	{
		return viewerService.addExistingFoodToExistingViewer(foodId, viewerId);
	}
	
	@Operation(summary = " toAdd  newFood to Viewer ", description = "API is used to add newFood to existing Viewer")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully newFood added to the Viewer "),
			@ApiResponse(responseCode = "404", description = "Viewer not found for the given id") })
	
	@PutMapping("/addNewFoodToExistingViewer")
	public ResponseEntity<ResponseStructure<Viewer>> addNewFoodToExistingViewer(@RequestParam int viewerId,@RequestBody Food newFood)
	{
		return viewerService.addNewFoodToExistingViewer(viewerId, newFood);
	}
	
	@Operation(summary = " toAdd Ticket to Viewer ", description = "API is used to add existing Ticket to existing Viewer")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Ticket added to the Viewer "),
			@ApiResponse(responseCode = "404", description = "Viewer not found for the given id"),
			@ApiResponse(responseCode = "404", description = "Ticket not found for the given id")})
	
	@PutMapping("/addExistingTicketToExistingViewer")
	public ResponseEntity<ResponseStructure<Viewer>> addExistingTicketToExistingViewer(@RequestParam int ticketId,@RequestParam int viewerId)
	{
		return viewerService.addExistingTicketToExistingViewer(ticketId, viewerId);
	}
	
	@Operation(summary = " toAdd  newTicket to Viewer ", description = "API is used to add newTicket to existing Viewer")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully newTicket added to the Viewer "),
			@ApiResponse(responseCode = "404", description = "Viewer not found for the given id"),
			@ApiResponse(responseCode = "404", description = "Ticket not found for the given id")})
	@PutMapping("/addNewTicketToExistingViewer")
	public ResponseEntity<ResponseStructure<Viewer>> addNewTicketToExistingViewer(@RequestParam int viewerId,@RequestBody Ticket newTicket)
	{
		return viewerService.addNewTicketToExistingViewer(viewerId, newTicket);
	}
	
	@Operation(summary = " Fetch Viewer ", description = "API is used to fetch Viewer")
	@ApiResponses(value = { @ApiResponse(responseCode = "301", description = "Successfully Viewer fetched "),
			@ApiResponse(responseCode = "404", description = "Viewer not found for the given id") })
	@GetMapping("/fetchViewerById")
	public ResponseEntity<ResponseStructure<Viewer>> fetchViewerById(@RequestParam int viewerId)
	{
		return viewerService.fetchViewerById(viewerId);
		
	}
	@Operation(summary = " Fetch All Viewers", description = "API is used to fetch all Viewers")
	@ApiResponses(value = { @ApiResponse(responseCode = "301", description = "Successfully all Viewers fetched ") })
	@GetMapping("/fetchAllViewer")
	public ResponseEntity<ResponseStructureList<Viewer>> fetchAllViewer()
	{
		return viewerService.fetchAllViewer();
		
	}
	
	@Operation(summary = " Update Viewer", description = "API is used to upadate the Viewer")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Viewer updated"),
			@ApiResponse(responseCode = "404", description = "Viewer not found for the given id") })
	@PutMapping("/updateViewerById")
	public ResponseEntity<ResponseStructure<Viewer>> updateViewerById(@RequestParam int oldViewerId,@RequestBody Viewer newViewer)
	{
	
		return viewerService.updateViewerById(oldViewerId, newViewer);
	}
	
	@Operation(summary = " Delete Viewer", description = "API is used to delete Viewer")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Viewer deleted"),
			@ApiResponse(responseCode = "404", description = "Viewer not found for the given id") })
	
	
	@DeleteMapping("/deleteViewerById")
	public ResponseEntity<ResponseStructure<Viewer>> deleteViewerById(@RequestParam int viewerId)
	{
		return viewerService.deleteViewerById(viewerId);
	}
}
