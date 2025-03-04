package com.project.Theatre_Management_System.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Theatre_Management_System.dao.FoodDao;
import com.project.Theatre_Management_System.dao.TicketDao;
import com.project.Theatre_Management_System.dao.ViewerDao;
import com.project.Theatre_Management_System.dto.Food;
import com.project.Theatre_Management_System.dto.Ticket;
import com.project.Theatre_Management_System.dto.Viewer;
import com.project.Theatre_Management_System.exception.FoodIdNotFoundException;
import com.project.Theatre_Management_System.exception.TicketIdNotFoundException;
import com.project.Theatre_Management_System.exception.ViewerIdNotFoundException;
import com.project.Theatre_Management_System.util.ResponseStructure;
import com.project.Theatre_Management_System.util.ResponseStructureList;

@Service
public class ViewerService {
	@Autowired
	ViewerDao viewerDao;
	
	@Autowired
	FoodDao foodDao;
	
	@Autowired
	TicketDao ticketDao;
	
	@Autowired
	ResponseStructure<Viewer> responseStructure;
	
	@Autowired
	ResponseStructureList<Viewer> responseStructureList;
	
	public ResponseEntity<ResponseStructure<Viewer>>  saveViewer(Viewer viewer)
	{
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Viewer inserted into DB");
		responseStructure.setData(viewerDao.saveViewer(viewer));
		return new ResponseEntity<ResponseStructure<Viewer>>(responseStructure,HttpStatus.CREATED) ;
	}
	
	public ResponseEntity<ResponseStructure<Viewer>> addExistingFoodToExistingViewer(int foodId,int viewerId)
	{
		Viewer viewer=viewerDao.fetchViewerById(viewerId);
		Food food=foodDao.fetchFoodById(foodId);
		if(viewer!=null&&food!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Food added to the Viewer in the  DB");
		responseStructure.setData(viewerDao.addExistingFoodToExistingViewer(foodId, viewerId));
		return new ResponseEntity<ResponseStructure<Viewer>>(responseStructure,HttpStatus.OK) ;
		}
		else if(food==null)
		{
			throw new FoodIdNotFoundException();
		}
		else {
			throw new ViewerIdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructure<Viewer>> addNewFoodToExistingViewer(int viewerId,Food newFood)
	{
		Viewer viewer=viewerDao.fetchViewerById(viewerId);
		if(viewer!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully newFood added to the Viewer in the  DB");
		responseStructure.setData(viewerDao.addNewFoodToExistingViewer(viewerId, newFood));
		return new ResponseEntity<ResponseStructure<Viewer>>(responseStructure,HttpStatus.OK) ;
		}
		else {
			throw new ViewerIdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructure<Viewer>> addExistingTicketToExistingViewer(int ticketId,int viewerId)
	{
		Viewer viewer=viewerDao.fetchViewerById(viewerId);
		Ticket ticket=ticketDao.fetchTicketById(ticketId);
		if(viewer!=null&&ticket!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Ticket added to Viewer in the DB");
		responseStructure.setData(viewerDao.addExistingTicketToExistingViewer(ticketId, viewerId));
		return new ResponseEntity<ResponseStructure<Viewer>>(responseStructure,HttpStatus.OK) ;
		}
		else if(ticket==null)
		{
			throw new TicketIdNotFoundException();
		}
		else {
			throw new ViewerIdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructure<Viewer>> addNewTicketToExistingViewer(int viewerId,Ticket newTicket)
	{
		Viewer viewer=viewerDao.fetchViewerById(viewerId);
		if(viewer!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully newTicket added to Viewer in the DB");
		responseStructure.setData(viewerDao.addNewTicketToExistingViewer(viewerId, newTicket));
		return new ResponseEntity<ResponseStructure<Viewer>>(responseStructure,HttpStatus.OK) ;
		}
		else {
			throw new ViewerIdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructure<Viewer>> fetchViewerById(int viewerId)
	{
		Viewer viewer=viewerDao.fetchViewerById(viewerId);
		if(viewer!=null)
		{
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Viewer fetched from the DB");
		responseStructure.setData(viewerDao.fetchViewerById(viewerId));
		return new ResponseEntity<ResponseStructure<Viewer>>(responseStructure,HttpStatus.FOUND) ;
		}
		else {
			throw new ViewerIdNotFoundException();
		}
		
	}
	public ResponseEntity<ResponseStructureList<Viewer>> fetchAllViewer()
	{
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Successfully all Viewer fetched from the DB");
		responseStructureList.setData(viewerDao.fetchAllViewer());
		return new ResponseEntity<ResponseStructureList<Viewer>>(responseStructureList,HttpStatus.FOUND) ;
		
	}
	public ResponseEntity<ResponseStructure<Viewer>> updateViewerById(int oldViewerId,Viewer newViewer)
	{
		Viewer viewer=viewerDao.fetchViewerById(oldViewerId);
		if(viewer!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Viewer got upadted from the DB");
		responseStructure.setData(viewerDao.updateViewerById(oldViewerId, newViewer));
		return new ResponseEntity<ResponseStructure<Viewer>>(responseStructure,HttpStatus.OK) ;
		}
		else {
			throw new ViewerIdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Viewer>> deleteViewerById(int viewerId)
	{
		Viewer viewer=viewerDao.fetchViewerById(viewerId);
		if(viewer!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Viewer got deleted from the DB");
		responseStructure.setData(viewerDao.deleteViewerById(viewerId));
		return new ResponseEntity<ResponseStructure<Viewer>>(responseStructure,HttpStatus.OK) ;
		}
		else {
			throw new ViewerIdNotFoundException();
		}
	}
}
