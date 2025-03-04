package com.project.Theatre_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Theatre_Management_System.dto.Manager;
import com.project.Theatre_Management_System.repo.ManagerRepo;

@Repository
public class ManagerDao {

	@Autowired
	ManagerRepo managerRepo;

	public Manager saveManager(Manager manager) {
		return managerRepo.save(manager);
	}

	public Manager fetchMangerById(int managerId) {
		Optional<Manager> dbManager = managerRepo.findById(managerId);
		if (dbManager.isPresent()) {
			return dbManager.get();
		} else {
			return null;
		}

	}

	public List<Manager> fetchAllManager() {
		return managerRepo.findAll();
	}

	public Manager updateManagerById(int oldManagerId, Manager newManager) {
		newManager.setManagerId(oldManagerId);
		return saveManager(newManager);
	}

	public Manager deleteManagerById(int managerId) {
		Manager manager = fetchMangerById(managerId);
		managerRepo.delete(manager);
		return manager;
	}
}
