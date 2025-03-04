package com.project.Theatre_Management_System.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Theatre_Management_System.dao.MovieDao;
import com.project.Theatre_Management_System.dao.ScreenDao;
import com.project.Theatre_Management_System.dao.SeatDao;
import com.project.Theatre_Management_System.dto.Movie;
import com.project.Theatre_Management_System.dto.Screen;
import com.project.Theatre_Management_System.dto.Seat;
import com.project.Theatre_Management_System.exception.MovieIdNotFoundException;
import com.project.Theatre_Management_System.exception.ScreenIdNotFoundException;
import com.project.Theatre_Management_System.exception.SeatIdNotFoundException;
import com.project.Theatre_Management_System.util.ResponseStructure;
import com.project.Theatre_Management_System.util.ResponseStructureList;

@Service
public class ScreenService {
	
	@Autowired
	ScreenDao screenDao;
	
	@Autowired
	MovieDao movieDao;
	
	@Autowired
	SeatDao seatDao;
	
	@Autowired
	ResponseStructure<Screen> responseStructure;
	
	@Autowired
	ResponseStructureList<Screen> responseStructureList;
	
	public ResponseEntity<ResponseStructure<Screen>>  saveScreen(Screen Screen)
	{
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully screen inserted into database");
		responseStructure.setData(screenDao.saveScreen(Screen));
		return new ResponseEntity<ResponseStructure<Screen>>(responseStructure,HttpStatus.CREATED)  ;
	}
	
	public ResponseEntity<ResponseStructure<Screen>> addExistingMovieToExistingScreen(int movieId,int screenId)
	{
		Screen screen=screenDao.fetchScreenById(screenId);
		Movie movie=movieDao.fetchMovieById(movieId);
		if(screen!=null&&movie!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Movie is added to the screen in database");
		responseStructure.setData(screenDao.addExistingMovieToExistingScreen(movieId, screenId));
		return new ResponseEntity<ResponseStructure<Screen>>(responseStructure,HttpStatus.OK)  ;
		}
		else if(movie==null)
		{
			throw new MovieIdNotFoundException();
		}
		else {
			throw new ScreenIdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Screen>> addExistingSeatToExistingScreen(int seatId,int screenId)
	{
		Screen screen=screenDao.fetchScreenById(screenId);
		Seat seat=seatDao.fetchSeatById(seatId);
		if(screen!=null&&seat!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Seat is added to the Screen in database");
		responseStructure.setData(screenDao.addExistingSeatToExistingScreen(seatId, screenId));
		return new ResponseEntity<ResponseStructure<Screen>>(responseStructure,HttpStatus.OK)  ;
		}
		else if(seat==null)
		{
			throw new SeatIdNotFoundException();
		}
		else
		{
			throw new ScreenIdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Screen>> addNewSeatToExistingScreen(int screenId,Seat newSeat)
	{
		Screen screen=screenDao.fetchScreenById(screenId);
		
		if(screen!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully newSeat is added to the Screen in database");
		responseStructure.setData(screenDao.addNewSeatToExistingScreen(screenId, newSeat));
		return new ResponseEntity<ResponseStructure<Screen>>(responseStructure,HttpStatus.OK)  ;
		}
		else
		{
			throw new ScreenIdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Screen>> fetchScreenById(int screenId)
	{
		Screen screen=screenDao.fetchScreenById(screenId);
		if(screen!=null)
		{
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully newSeat is added to the Screen in database");
		responseStructure.setData(screenDao.fetchScreenById(screenId));
		return new ResponseEntity<ResponseStructure<Screen>>(responseStructure,HttpStatus.FOUND)  ;
		}
		else
		{
			throw new ScreenIdNotFoundException();
		}
		
	}
	public ResponseEntity<ResponseStructureList<Screen>> fetchAllScreen()
	{
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Successfully newSeat is added to the Screen in database");
		responseStructureList.setData(screenDao.fetchAllScreen());
		return new ResponseEntity<ResponseStructureList<Screen>>(responseStructureList,HttpStatus.FOUND)  ;
		
	}
	public ResponseEntity<ResponseStructure<Screen>> updateScreenById(int oldScreenId,Screen newScreen)
	{
		Screen screen=screenDao.fetchScreenById(oldScreenId);
		if(screen!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Screen got updated in the database");
		responseStructure.setData(screenDao.updateScreenById(oldScreenId, newScreen));
		return new ResponseEntity<ResponseStructure<Screen>>(responseStructure,HttpStatus.OK)  ;
		}
		else
		{
			throw new ScreenIdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Screen>> deleteScreenById(int screenId)
	{
		Screen screen=screenDao.fetchScreenById(screenId);
		if(screen!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Screen got deleted from the database");
		responseStructure.setData(screenDao.deleteScreenById(screenId));
		return new ResponseEntity<ResponseStructure<Screen>>(responseStructure,HttpStatus.OK)  ;
		}
		else
		{
			throw new ScreenIdNotFoundException();
		}
	}
	

}
