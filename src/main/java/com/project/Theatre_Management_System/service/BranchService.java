package com.project.Theatre_Management_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Theatre_Management_System.dao.AddressDao;
import com.project.Theatre_Management_System.dao.BranchDao;
import com.project.Theatre_Management_System.dao.ManagerDao;
import com.project.Theatre_Management_System.dao.ScreenDao;
import com.project.Theatre_Management_System.dao.StaffDao;
import com.project.Theatre_Management_System.dto.Address;
import com.project.Theatre_Management_System.dto.Branch;
import com.project.Theatre_Management_System.dto.Manager;
import com.project.Theatre_Management_System.dto.Screen;
import com.project.Theatre_Management_System.dto.Staff;
import com.project.Theatre_Management_System.exception.AddressIdNotFoundException;
import com.project.Theatre_Management_System.exception.BranchIdNotFoundException;
import com.project.Theatre_Management_System.exception.ManagerIdNotFoundException;
import com.project.Theatre_Management_System.exception.ScreenIdNotFoundException;
import com.project.Theatre_Management_System.exception.StaffIdNotFoundException;
import com.project.Theatre_Management_System.util.ResponseStructure;
import com.project.Theatre_Management_System.util.ResponseStructureList;

@Service
public class BranchService {
	
	@Autowired
	BranchDao branchDao;
	
	@Autowired
	ManagerDao managerDao;
	
	@Autowired
	AddressDao addressDao;
	
	@Autowired
	StaffDao staffDao;
	
	@Autowired
	ScreenDao screenDao;
	
	@Autowired
	ResponseStructure<Branch> responseStructure;
	
	@Autowired
	ResponseStructureList<Branch> responseStructureList;
	
	public ResponseEntity<ResponseStructure<Branch>>  saveBranch(Branch branch)
	{
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Branch inserted into DB");
		responseStructure.setData(branchDao.saveBranch(branch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Branch>> addExistingManagerToExistingBranch(int managerId,int branchId) {
		Branch branch= branchDao.fetchBranchById(branchId);
		Manager manager=managerDao.fetchMangerById(managerId);
		
		if(branch!=null&&manager!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Manager added to Branch in the DB");
		responseStructure.setData(branchDao.addExistingManagerToExistingBranch(managerId, branchId));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK) ;
		}
		else if(manager==null)
		{
			throw new ManagerIdNotFoundException();
		}
		else {
			throw new BranchIdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Branch>> addExistingAddressToExistingBranch(int addressId,int branchId)
	{
		Branch branch= branchDao.fetchBranchById(branchId);
		Address address=addressDao.fetchAddressById(addressId);
		if(branch!=null &&address!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully newManager added to Branch in the DB");
		responseStructure.setData(branchDao.addExistingAddressToExistingBranch(addressId, branchId));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK) ;
		}
		else if(address==null )
		{
			throw new AddressIdNotFoundException();
		}
		else {
			throw new BranchIdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructure<Branch>> addExistingStaffToExistingBranch(int staffId,int branchId) {
		Branch branch= branchDao.fetchBranchById(branchId);
		Staff staff=staffDao.fetchStaffById(staffId);
		if(branch!=null&&staff!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Staff added to Branch in the DB");
		responseStructure.setData(branchDao.addExistingStaffToExistingBranch(staffId, branchId));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK) ;
		}
		else if(staff==null)
		{
			throw new StaffIdNotFoundException();
		}
		else {
			throw new BranchIdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Branch>> addNewStaffToExistingBranch(int branchId,Staff newStaff)
	{
		Branch branch= branchDao.fetchBranchById(branchId);
		if(branch!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully newStaff added to Branch in the DB");
		responseStructure.setData(branchDao.addNewStaffToExistingBranch(branchId, newStaff));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK) ;
		}
		else {
			throw new BranchIdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructure<Branch>> addExistingScreenToExistingBranch(int screenId,int branchId)
	{
		Branch branch= branchDao.fetchBranchById(branchId);
		Screen screen =screenDao.fetchScreenById(screenId);
		if(branch!=null&&screen!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Screen added to Branch in the DB");
		responseStructure.setData(branchDao.addExistingScreenToExistingBranch(screenId, branchId));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK) ;
		}
		else if(screen==null)
		{
			throw new ScreenIdNotFoundException();
		}
		else {
			throw new BranchIdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Branch>> addNewScreenToExistingBranch(int branchId,Screen newScreen)
	{
		Branch branch= branchDao.fetchBranchById(branchId);
		if(branch!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully newScreen added to Branch in the DB");
		responseStructure.setData(branchDao.addNewScreenToExistingBranch(branchId, newScreen));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK) ;
		}
		else {
			throw new BranchIdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> fetchBranchById(int branchId)
	{
		Branch branch= branchDao.fetchBranchById(branchId);
		if(branch!=null)
		{
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Branch fetched from the DB");
		responseStructure.setData(branchDao.fetchBranchById(branchId));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.FOUND) ;
		}
		else {
			throw new BranchIdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructureList<Branch>> fetchAllBranch()
	{
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Successfully all Branch fetched from the DB");
		responseStructureList.setData(branchDao.fetchAllBranch());
		return new ResponseEntity<ResponseStructureList<Branch>>(responseStructureList,HttpStatus.FOUND) ;
	}
	
	public ResponseEntity<ResponseStructure<Branch>> updateBranchById(int oldBranchId,Branch newBranch)
	{
		Branch branch= branchDao.fetchBranchById(oldBranchId);
		if(branch!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Branch got updated in the DB");
		responseStructure.setData(branchDao.updateBranchById(oldBranchId, newBranch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK) ;
		}
		else {
			throw new BranchIdNotFoundException();
		}
		
	}
	
	public ResponseEntity<ResponseStructure<Branch>> deleteBranchById(int branchId)
	{
		Branch branch= branchDao.fetchBranchById(branchId);
		if(branch!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Branch got deleted from the DB");
		responseStructure.setData(branchDao.deletBranchById(branchId));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK) ;
		}
		else {
			throw new BranchIdNotFoundException();
		}
	}
	

}
