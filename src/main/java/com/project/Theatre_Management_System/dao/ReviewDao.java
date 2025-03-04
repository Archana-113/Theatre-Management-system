package com.project.Theatre_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Theatre_Management_System.dto.Review;
import com.project.Theatre_Management_System.repo.ReviewRepo;

@Repository
public class ReviewDao {
	
	@Autowired
	ReviewRepo reviewRepo;
	
	public Review saveReview(Review review)
	{
		return reviewRepo.save(review);
	}
	public Review fetchReviewById(int reviewId)
	{
		Optional<Review> dbReview= reviewRepo.findById(reviewId);
		if(dbReview.isPresent())
		{
			return dbReview.get();
		}
		return null;
		
	}
	public List<Review> fetchAllReview()
	{
		return reviewRepo.findAll();
		
	}
	public Review updateReviewById(int oldReviewId,Review newReview)
	{
		newReview.setReviewId(oldReviewId);
		return saveReview(newReview);
	}
	
	public Review deleteReviewById(int reviewId)
	{
		Review review=fetchReviewById(reviewId);
		reviewRepo.delete(review);
		return review;
	}


}
