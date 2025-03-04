package com.project.Theatre_Management_System.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Theatre_Management_System.dao.SeatDao;
import com.project.Theatre_Management_System.dao.ViewerDao;
import com.project.Theatre_Management_System.dto.Seat;
import com.project.Theatre_Management_System.dto.Viewer;
import com.project.Theatre_Management_System.exception.SeatIdNotFoundException;
import com.project.Theatre_Management_System.exception.ViewerIdNotFoundException;
import com.project.Theatre_Management_System.util.ResponseStructure;
import com.project.Theatre_Management_System.util.ResponseStructureList;

@Service
public class SeatService {
	
	@Autowired
	SeatDao seatDao;
	
	@Autowired
	ViewerDao viewerDao;
	
	@Autowired
	ResponseStructure<Seat> responseStructure;
	
	@Autowired
	ResponseStructureList<Seat> responseStructureList;
	
	public ResponseEntity<ResponseStructure<Seat>>  saveSeat(Seat seat)
	{
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully seat inserted into DB");
		responseStructure.setData(seatDao.saveSeat(seat));
		return new ResponseEntity<ResponseStructure<Seat>>(responseStructure,HttpStatus.CREATED) ;
	}
	
	public ResponseEntity<ResponseStructure<Seat>> addExistingViewerToExistingSeat(int viewerId,int seatId)
	{
		Seat seat=seatDao.fetchSeatById(seatId);
		Viewer viewer=viewerDao.fetchViewerById(viewerId);
		if(seat!=null&&viewer!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully  Viewer added to the Seat in the DB");
		responseStructure.setData(seatDao.addExistingViewerToExistingSeat(viewerId, seatId));
		return new ResponseEntity<ResponseStructure<Seat>>(responseStructure,HttpStatus.OK) ;
		}
		else if(viewer==null)
		{
			throw new ViewerIdNotFoundException();
		}
		else {
			throw new SeatIdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Seat>> fetchSeatById(int seatId)
	{
		Seat seat=seatDao.fetchSeatById(seatId);
		if(seat!=null)
		{
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully  Seat fetched from the DB");
		responseStructure.setData(seatDao.fetchSeatById(seatId));
		return new ResponseEntity<ResponseStructure<Seat>>(responseStructure,HttpStatus.FOUND) ;
		}
		else {
			throw new SeatIdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructureList<Seat>> fetchAllSeat()
	{
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Successfully All Seats fetched from the DB");
		responseStructureList.setData(seatDao.fetchAllSeat());
		return new ResponseEntity<ResponseStructureList<Seat>>(responseStructureList,HttpStatus.FOUND) ;
		
	}
	public ResponseEntity<ResponseStructure<Seat>> updateSeatById(int oldSeatId,Seat newSeat)
	{
		Seat seat=seatDao.fetchSeatById(oldSeatId);
		if(seat!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully  Seat got updated in the DB");
		responseStructure.setData(seatDao.updateSeatById(oldSeatId, newSeat));
		return new ResponseEntity<ResponseStructure<Seat>>(responseStructure,HttpStatus.OK) ;
		}
		else {
			throw  new SeatIdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructure<Seat>> deleteSeatById(int seatId)
	{
		Seat seat=seatDao.fetchSeatById(seatId);
		if(seat!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully  Seat deleted from the DB");
		responseStructure.setData(seatDao.deleteSeatById(seatId));
		return new ResponseEntity<ResponseStructure<Seat>>(responseStructure,HttpStatus.OK) ;
		}
		else {
		         throw new SeatIdNotFoundException();
		}
	}
}
