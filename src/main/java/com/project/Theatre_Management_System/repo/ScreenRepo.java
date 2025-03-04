package com.project.Theatre_Management_System.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Theatre_Management_System.dto.Screen;

public interface ScreenRepo extends JpaRepository<Screen, Integer> {
	

}
