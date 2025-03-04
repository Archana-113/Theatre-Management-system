package com.project.Theatre_Management_System.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Theatre_Management_System.dto.Owner;

public interface OwnerRepo extends JpaRepository<Owner, Integer> {

}
