package com.project.Theatre_Management_System.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Theatre_Management_System.dto.Seat;

public interface SeatRepo extends JpaRepository<Seat, Integer> {

}
