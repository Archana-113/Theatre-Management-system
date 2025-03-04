package com.project.Theatre_Management_System.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Theatre_Management_System.dto.Review;
import com.project.Theatre_Management_System.exception.ReviewIdNotFoundException;
import com.project.Theatre_Management_System.dao.ReviewDao;
import com.project.Theatre_Management_System.util.ResponseStructure;
import com.project.Theatre_Management_System.util.ResponseStructureList;

@Service
public class ReviewService {
	@Autowired
	ReviewDao reviewDao;
	
	@Autowired
	ResponseStructure<Review> responseStructure;
	
	@Autowired
	ResponseStructureList<Review> responseStructureList;
	
	public ResponseEntity<ResponseStructure<Review>>  saveReview(Review review)
	{
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Review inserted into DB");
		responseStructure.setData(reviewDao.saveReview(review));
		return new ResponseEntity<ResponseStructure<Review>>(responseStructure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<Review>> fetchReviewById(int reviewId)
	{
		Review review=reviewDao.fetchReviewById(reviewId);
		if(review!=null)
		{
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Review fetched from the DB");
		responseStructure.setData(reviewDao.fetchReviewById(reviewId));
		return new ResponseEntity<ResponseStructure<Review>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new ReviewIdNotFoundException();
		}
		
	}
	public ResponseEntity<ResponseStructureList<Review>> fetchAllReview()
	{
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Successfully All Reviews fetched from the DB");
		responseStructureList.setData(reviewDao.fetchAllReview());
		return new ResponseEntity<ResponseStructureList<Review>>(responseStructureList,HttpStatus.FOUND);
		
	}
	public ResponseEntity<ResponseStructure<Review>> updateReviewById(int oldReviewId,Review newReview)
	{
		Review review=reviewDao.fetchReviewById(oldReviewId);
		if(review!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Review got updated in the DB");
		responseStructure.setData(reviewDao.updateReviewById(oldReviewId, newReview));
		return new ResponseEntity<ResponseStructure<Review>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new ReviewIdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Review>> deleteReviewById(int reviewId)
	{
		Review review=reviewDao.fetchReviewById(reviewId);
		if(review!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Review got deleted from the DB");
		responseStructure.setData(reviewDao.deleteReviewById(reviewId));
		return new ResponseEntity<ResponseStructure<Review>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new ReviewIdNotFoundException();
		}
	}
	

}
