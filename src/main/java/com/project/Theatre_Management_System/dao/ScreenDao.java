package com.project.Theatre_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Theatre_Management_System.dto.Movie;
import com.project.Theatre_Management_System.dto.Screen;
import com.project.Theatre_Management_System.dto.Seat;
import com.project.Theatre_Management_System.repo.ScreenRepo;

@Repository
public class ScreenDao {
	
	@Autowired
	ScreenRepo screenRepo;
	
	@Autowired
	MovieDao movieDao;
	
	@Autowired
	SeatDao seatDao;

	
	public Screen saveScreen(Screen screen)
	{
		return screenRepo.save(screen);
	}
	public Screen addExistingMovieToExistingScreen(int movieId,int screenId) {
	   Movie movie=	movieDao.fetchMovieById(movieId);
	   Screen screen= fetchScreenById(screenId);
	   screen.setMovie(movie);
	   return saveScreen(screen);
	}
	
	public Screen addExistingSeatToExistingScreen(int seatId,int screenId)
	{
		Seat seat=seatDao.fetchSeatById(seatId);
		Screen screen=fetchScreenById(screenId);
		List<Seat> list=screen.getSeat();
		list.add(seat);
		screen.setSeat(list);
		return saveScreen(screen);
	}
	public Screen addNewSeatToExistingScreen(int screenId,Seat newSeat)
	{
		Screen screen=fetchScreenById(screenId);
		List<Seat> list=screen.getSeat();
		list.add(newSeat);
		screen.setSeat(list);
		return saveScreen(screen);
	}
	
	public Screen fetchScreenById(int screenId)
	{
		Optional<Screen> dbScreen= screenRepo.findById(screenId);
		if(dbScreen.isPresent())
		{
			return dbScreen.get();
		}
		return null;	
	}
	public List<Screen> fetchAllScreen()
	{
		return screenRepo.findAll();
		
	}
	public Screen updateScreenById(int oldScreenId,Screen newScreen)
	{
		newScreen.setScreenId(oldScreenId);
		return saveScreen(newScreen);
	}
	
	public Screen deleteScreenById(int screenId)
	{
		Screen screen=fetchScreenById(screenId);
		screenRepo.delete(screen);
		return screen;
	}

}
