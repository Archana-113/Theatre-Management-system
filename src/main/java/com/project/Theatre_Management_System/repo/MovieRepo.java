package com.project.Theatre_Management_System.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Theatre_Management_System.dto.Movie;

public interface MovieRepo extends JpaRepository<Movie, Integer>{
	

}
