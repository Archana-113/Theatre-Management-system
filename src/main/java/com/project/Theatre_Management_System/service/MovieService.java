package com.project.Theatre_Management_System.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Theatre_Management_System.dao.MovieDao;
import com.project.Theatre_Management_System.dao.ReviewDao;
import com.project.Theatre_Management_System.dao.ViewerDao;
import com.project.Theatre_Management_System.dto.Movie;
import com.project.Theatre_Management_System.dto.Review;
import com.project.Theatre_Management_System.dto.Viewer;
import com.project.Theatre_Management_System.exception.MovieIdNotFoundException;
import com.project.Theatre_Management_System.exception.ReviewIdNotFoundException;
import com.project.Theatre_Management_System.exception.ViewerIdNotFoundException;
import com.project.Theatre_Management_System.util.ResponseStructure;
import com.project.Theatre_Management_System.util.ResponseStructureList;

@Service
public class MovieService {
	@Autowired
	MovieDao movieDao;
	
	@Autowired
	ReviewDao reviewDao;
	
	@Autowired
	ViewerDao viewerDao;
	
	
	@Autowired
	ResponseStructure<Movie> responseStructure;
	
	@Autowired
	ResponseStructureList<Movie> responseStructureList;
	
	public ResponseEntity<ResponseStructure<Movie>>  saveMovie(Movie movie)
	{
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Movie inserted in  DB");
		responseStructure.setData(movieDao.saveMovie(movie));
		return new ResponseEntity<ResponseStructure<Movie>>(responseStructure,HttpStatus.CREATED) ;
	}
	
	public ResponseEntity<ResponseStructure<Movie>> addExistingViewerToExistingMovie(int viewerId,int movieId)
	{
		Movie movie=movieDao.fetchMovieById(movieId);
		Viewer viewer=viewerDao.fetchViewerById(viewerId);
		if(movie!=null&&viewer!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully  Viewer added to the Movie in the DB");
		responseStructure.setData(movieDao.addExistingViewerToExistingMovie(viewerId, movieId));
		return new ResponseEntity<ResponseStructure<Movie>>(responseStructure,HttpStatus.OK) ;
		}
		else if(viewer==null)
		{
			throw new ViewerIdNotFoundException();
		}
		else {
			throw new MovieIdNotFoundException();
		}
	}
		
	public ResponseEntity<ResponseStructure<Movie>> addNewViewerToExistingMovie(int movieId,Viewer newViewer)
	{
		Movie movie=movieDao.fetchMovieById(movieId);
		if(movie!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully  newViewer added to the Movie in the DB");
		responseStructure.setData(movieDao.addNewViewerToExistingMovie(movieId, newViewer));
		return new ResponseEntity<ResponseStructure<Movie>>(responseStructure,HttpStatus.OK) ;
		}
		else {
			throw new MovieIdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructure<Movie>> addExistingReviewToExistingMovie(int reviewId,int movieId)
	{
		Movie movie=movieDao.fetchMovieById(movieId);
		Review review=reviewDao.fetchReviewById(reviewId);
		if(movie!=null&&review!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully  Review addeded to the Movie in the DB");
		responseStructure.setData(movieDao.addExistingReviewToExistingMovie(reviewId, movieId));
		return new ResponseEntity<ResponseStructure<Movie>>(responseStructure,HttpStatus.OK) ;
		}
		else if(review==null)
		{
			throw new ReviewIdNotFoundException();
		}
		else {
			throw new MovieIdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructure<Movie>> addNewReviewToExistingMovie(int movieId,Review newReview)
	{
		Movie movie=movieDao.fetchMovieById(movieId);
		if(movie!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully  Review added to the Movie in the DB");
		responseStructure.setData(movieDao.addNewReviewToExistingMovie(movieId, newReview));
		return new ResponseEntity<ResponseStructure<Movie>>(responseStructure,HttpStatus.OK) ;
		}
		else {
			throw new MovieIdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Movie>> fetchMovieById(int movieId)
	{
		Movie movie=movieDao.fetchMovieById(movieId);
		if(movie!=null)
		{
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully  Movie fetched from the DB");
		responseStructure.setData(movieDao.fetchMovieById(movieId));
		return new ResponseEntity<ResponseStructure<Movie>>(responseStructure,HttpStatus.FOUND) ;
		}
		else {
			throw new MovieIdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructureList<Movie>> fetchAllMovie()
	{
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Successfully All Movies fetched from the DB");
		responseStructureList.setData(movieDao.fetchAllMovie());
		return new ResponseEntity<ResponseStructureList<Movie>>(responseStructureList,HttpStatus.FOUND) ;		
	}
	public ResponseEntity<ResponseStructure<Movie>> updateMovieById(int oldMovieId,Movie newMovie)
	{
		Movie movie=movieDao.fetchMovieById(oldMovieId);
		if(movie!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully  Movie got updated in the DB");
		responseStructure.setData(movieDao.updateMovieById(oldMovieId, newMovie));
		return new ResponseEntity<ResponseStructure<Movie>>(responseStructure,HttpStatus.OK) ;	
		}
		else {
			throw new MovieIdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructure<Movie>> deleteMovieById(int movieId)
	{
		Movie movie=movieDao.fetchMovieById(movieId);
		if(movie!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully  Movie got deleted from the DB");
		responseStructure.setData(movieDao.deleteMovieById(movieId));
		return new ResponseEntity<ResponseStructure<Movie>>(responseStructure,HttpStatus.OK) ;
		}
		else {
			throw new MovieIdNotFoundException();
		}
	}
}
