package com.project.Theatre_Management_System.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Theatre_Management_System.dao.ManagerDao;
import com.project.Theatre_Management_System.dto.Manager;
import com.project.Theatre_Management_System.exception.ManagerIdNotFoundException;
import com.project.Theatre_Management_System.util.ResponseStructure;
import com.project.Theatre_Management_System.util.ResponseStructureList;

@Service
public class ManagerService {
	
	@Autowired
	ManagerDao managerDao;
	
	@Autowired
	ResponseStructure<Manager> responseStructure;
	
	@Autowired
	ResponseStructureList<Manager> responseStructureList;
	
	public ResponseEntity<ResponseStructure<Manager>>  saveManager(Manager manager)
	{
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Manager inserted into DB");
		responseStructure.setData(managerDao.saveManager(manager));
		return new ResponseEntity<ResponseStructure<Manager>>(responseStructure,HttpStatus.CREATED) ;
	}

	public ResponseEntity<ResponseStructure<Manager>> fetchMangerById(int managerId)
	{
		Manager manager=managerDao.fetchMangerById(managerId);
		if(manager!=null)
		{
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Manager fetched from the DB");
		responseStructure.setData(managerDao.fetchMangerById(managerId));
		return new ResponseEntity<ResponseStructure<Manager>>(responseStructure,HttpStatus.FOUND) ;
		}
		else {
			throw new ManagerIdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructureList<Manager>> fetchAllManager()
	{
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Successfully all the Managers fetched from the DB");
		responseStructureList.setData(managerDao.fetchAllManager());
		return new ResponseEntity<ResponseStructureList<Manager>>(responseStructureList,HttpStatus.FOUND) ;		
	}
	public ResponseEntity<ResponseStructure<Manager>> updateManagerById(int oldManagerId,Manager newManager)
	{
		Manager manager=managerDao.fetchMangerById(oldManagerId);
		if(manager!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Manager got updated in the DB");
		responseStructure.setData(managerDao.updateManagerById(oldManagerId, newManager));
		return new ResponseEntity<ResponseStructure<Manager>>(responseStructure,HttpStatus.OK);		
		}
		else {
			throw new ManagerIdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructure<Manager>> deleteManagerById(int managerId)
	{
		Manager manager=managerDao.fetchMangerById(managerId);
		if(manager!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Manager got deleted from the DB");
		responseStructure.setData(managerDao.deleteManagerById(managerId));	
		return new ResponseEntity<ResponseStructure<Manager>>(responseStructure,HttpStatus.OK) ;
		}
		else {
			throw new ManagerIdNotFoundException();
		}
	}
}
