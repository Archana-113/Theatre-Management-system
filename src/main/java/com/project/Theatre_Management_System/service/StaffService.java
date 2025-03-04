package com.project.Theatre_Management_System.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Theatre_Management_System.dao.StaffDao;
import com.project.Theatre_Management_System.dto.Staff;
import com.project.Theatre_Management_System.exception.StaffIdNotFoundException;
import com.project.Theatre_Management_System.util.ResponseStructure;
import com.project.Theatre_Management_System.util.ResponseStructureList;

@Service
public class StaffService {
	
	@Autowired
	StaffDao staffDao;
	
	@Autowired
	ResponseStructure<Staff> responseStructure;
	
	@Autowired
	ResponseStructureList<Staff> responseStructureList;
	
	public ResponseEntity<ResponseStructure<Staff>>  saveStaff(Staff staff)
	{
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Staff inserted into DB");
		responseStructure.setData(staffDao.saveStaff(staff));
		return new ResponseEntity<ResponseStructure<Staff>>(responseStructure,HttpStatus.CREATED) ;
	}
	public ResponseEntity<ResponseStructure<Staff>> fetchStaffById(int staffId)
	{
		Staff staff =staffDao.fetchStaffById(staffId);
		if(staff!=null)
		{
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Staff fetched from the DB");
		responseStructure.setData(staffDao.fetchStaffById(staffId));
		return new ResponseEntity<ResponseStructure<Staff>>(responseStructure,HttpStatus.FOUND) ;
		}
		else {
			throw new StaffIdNotFoundException();
		}
		
	}
	public ResponseEntity<ResponseStructureList<Staff>> fetchAllStaff()
	{
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Successfully Staff fetched from the DB");
		responseStructureList.setData(staffDao.fetchAllStaff());
		return new ResponseEntity<ResponseStructureList<Staff>>(responseStructureList,HttpStatus.FOUND) ;
	}
	public ResponseEntity<ResponseStructure<Staff>> updateStaffById(int oldStaffId,Staff newStaff)
	{
		Staff staff =staffDao.fetchStaffById(oldStaffId);
		if(staff!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Staff got updated int the DB");
		responseStructure.setData(staffDao.updateStaffById(oldStaffId, newStaff));
		return new ResponseEntity<ResponseStructure<Staff>>(responseStructure,HttpStatus.OK) ;
		}
		else {
			throw new StaffIdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Staff>> deleteStaffById(int staffId)
	{
		Staff staff =staffDao.fetchStaffById(staffId);
		if(staff!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Staff got deleted from the  DB");
		responseStructure.setData(staffDao.deleteStaffById(staffId));
		return new ResponseEntity<ResponseStructure<Staff>>(responseStructure,HttpStatus.OK) ;
		}
		else {
			throw new StaffIdNotFoundException();
		}
	}
}
