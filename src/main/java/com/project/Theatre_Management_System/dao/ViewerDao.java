package com.project.Theatre_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Theatre_Management_System.dto.Food;
import com.project.Theatre_Management_System.dto.Ticket;
import com.project.Theatre_Management_System.dto.Viewer;
import com.project.Theatre_Management_System.repo.ViewerRepo;
@Repository
public class ViewerDao {
	@Autowired
	ViewerRepo viewerRepo;
	
	@Autowired
	FoodDao foodDao;
	
	@Autowired
	TicketDao ticketDao;
	
	public Viewer saveViewer(Viewer viewer)
	{
		return viewerRepo.save(viewer);
	}
	
	public Viewer addExistingFoodToExistingViewer(int foodId,int viewerId)
	{
		Food food=foodDao.fetchFoodById(foodId);
		Viewer viewer=fetchViewerById(viewerId);
		List<Food> list=viewer.getFood();
		list.add(food);
		viewer.setFood(list);
		return saveViewer(viewer);
	}
	public Viewer addNewFoodToExistingViewer(int viewerId,Food newFood)
	{
		Viewer viewer= fetchViewerById(viewerId);
		List<Food> list=viewer.getFood();
		list.add(newFood);
		viewer.setFood(list);
		return saveViewer(viewer);
	}
	public Viewer addExistingTicketToExistingViewer(int ticketId,int viewerId)
	{
		Ticket ticket=ticketDao.fetchTicketById(ticketId);
		Viewer viewer=fetchViewerById(viewerId);
		List<Ticket> list=viewer.getTicket();
		list.add(ticket);
		viewer.setTicket(list);
		return saveViewer(viewer);
	}
	public Viewer addNewTicketToExistingViewer(int viewerId,Ticket newTicket)
	{
		Viewer viewer= fetchViewerById(viewerId);
		List<Ticket> list=viewer.getTicket();
		list.add(newTicket);
		viewer.setTicket(list);
		return saveViewer(viewer);
	}
	
	
	
	public Viewer fetchViewerById(int viewerId)
	{
		Optional<Viewer> dbViewer= viewerRepo.findById(viewerId);
		if(dbViewer.isEmpty())
		{
			return null;
		}
		return dbViewer.get();
		
	}
	public List<Viewer> fetchAllViewer()
	{
		return viewerRepo.findAll();
		
	}
	public Viewer updateViewerById(int oldViewerId,Viewer newViewer)
	{
		newViewer.setViewerId(oldViewerId);
		return saveViewer(newViewer);
	}
	
	public Viewer deleteViewerById(int viewerId)
	{
		Viewer Viewer=fetchViewerById(viewerId);
		viewerRepo.delete(Viewer);
		return Viewer;
	}

}
