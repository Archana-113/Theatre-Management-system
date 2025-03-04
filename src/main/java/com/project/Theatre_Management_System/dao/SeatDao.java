package com.project.Theatre_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Theatre_Management_System.dto.Seat;
import com.project.Theatre_Management_System.dto.Viewer;
import com.project.Theatre_Management_System.repo.SeatRepo;

@Repository
public class SeatDao {
	
	@Autowired
	SeatRepo seatRepo;
	
	@Autowired
	ViewerDao viewerDao;
	
	
	public Seat saveSeat(Seat seat)
	{
		return seatRepo.save(seat);
	}
	
	public Seat addExistingViewerToExistingSeat(int viewerId,int seatId)
	{
	   Viewer viewer= viewerDao.fetchViewerById(viewerId);
	   Seat seat= fetchSeatById(seatId);
	   seat.setViewer(viewer);
	   return saveSeat(seat);
	    
	}
	public Seat fetchSeatById(int seatId)
	{
		Optional<Seat> dbSeat= seatRepo.findById(seatId);
		if(dbSeat.isEmpty())
		{
			return null;
		}
		return dbSeat.get();
		
	}
	public List<Seat> fetchAllSeat()
	{
		return seatRepo.findAll();
		
	}
	public Seat updateSeatById(int oldSeatId,Seat newSeat)
	{
		newSeat.setSeatId(oldSeatId);
		return saveSeat(newSeat);
	}
	
	public Seat deleteSeatById(int seatId)
	{
		Seat seat=fetchSeatById(seatId);
		seatRepo.delete(seat);
		return seat;
	}
	
	

}
