package com.project.Theatre_Management_System.dto;

import java.sql.Time;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movieId;
	private String movieName;
	private String movieType;
	private Time movieDuration;
	private String movieLanguage;
	private double movieBudget;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Viewer>  viewer;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Review> review;
	
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieType() {
		return movieType;
	}
	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}
	public Time getMovieDuration() {
		return movieDuration;
	}
	public void setMovieDuration(Time movieDuration) {
		this.movieDuration = movieDuration;
	}
	public String getMovieLanguage() {
		return movieLanguage;
	}
	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}
	public double getMovieBudget() {
		return movieBudget;
	}
	public void setMovieBudget(double movieBudget) {
		this.movieBudget = movieBudget;
	}
	public List<Viewer> getViewer() {
		return viewer;
	}
	public void setViewer(List<Viewer> viewer) {
		this.viewer = viewer;
	}
	public List<Review> getReview() {
		return review;
	}
	public void setReview(List<Review> review) {
		this.review = review;
	}	
	
}
