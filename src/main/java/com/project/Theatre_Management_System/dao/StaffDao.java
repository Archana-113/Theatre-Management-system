package com.project.Theatre_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Theatre_Management_System.dto.Staff;
import com.project.Theatre_Management_System.repo.StaffRepo;

@Repository
public class StaffDao {
	@Autowired
	StaffRepo staffRepo;
	
	public Staff saveStaff(Staff staff)
	{
		return staffRepo.save(staff);
	}
	public Staff fetchStaffById(int staffId)
	{
		Optional<Staff> dbStaff= staffRepo.findById(staffId);
		if(dbStaff.isEmpty())
		{
			return null;
		}
		return dbStaff.get();
		
	}
	public List<Staff> fetchAllStaff()
	{
		return staffRepo.findAll();
		
	}
	public Staff updateStaffById(int oldStaffId,Staff newStaff)
	{
		newStaff.setStaffId(oldStaffId);
		return saveStaff(newStaff);
	}
	
	public Staff deleteStaffById(int staffId)
	{
		Staff staff=fetchStaffById(staffId);
		staffRepo.delete(staff);
		return staff;
	}

}
