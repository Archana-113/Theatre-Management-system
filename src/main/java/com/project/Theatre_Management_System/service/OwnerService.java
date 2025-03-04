package com.project.Theatre_Management_System.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Theatre_Management_System.dao.OwnerDao;
import com.project.Theatre_Management_System.dao.TheatreDao;
import com.project.Theatre_Management_System.dto.Owner;
import com.project.Theatre_Management_System.dto.Theatre;
import com.project.Theatre_Management_System.exception.OwnerIdNotFoundException;
import com.project.Theatre_Management_System.exception.TheatreIdNotFoundException;
import com.project.Theatre_Management_System.util.ResponseStructure;
import com.project.Theatre_Management_System.util.ResponseStructureList;

@Service
public class OwnerService {
	
	@Autowired
	OwnerDao ownerDao;
	
	@Autowired
	TheatreDao theatreDao;
	
	@Autowired
	ResponseStructure<Owner> responseStructure;
	
	@Autowired
	ResponseStructureList<Owner> responseStructureList;
	
	public ResponseEntity<ResponseStructure<Owner>>  saveOwner(Owner owner)
	{
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Owner inserted into DB");
		responseStructure.setData(ownerDao.saveOwner(owner));
		return new ResponseEntity<ResponseStructure<Owner>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Owner>> addExixtingTheatreToExistingOwner(int theatreId,int ownerId)
	{
		Owner owner=ownerDao.fetchOwnerById(ownerId);
		Theatre theatre=theatreDao.fetchTheatreById(theatreId);

	    if(owner!=null&&theatre!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Theatre added to the Owner into DB");
		responseStructure.setData(ownerDao.addExixtingTheatreToExistingOwner(theatreId, ownerId));
		return new ResponseEntity<ResponseStructure<Owner>>(responseStructure,HttpStatus.OK)  ;
		}
	    else if(theatre==null)
	    {
	    	throw new TheatreIdNotFoundException();
	    }
		else {
			throw new OwnerIdNotFoundException(); 
		}	
	}
	
	public ResponseEntity<ResponseStructure<Owner>> fetchOwnerById(int ownerId)
	{	
		Owner owner= ownerDao.fetchOwnerById(ownerId);
		if(owner!=null)
		{
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Owner fetched from the DB");
		responseStructure.setData(ownerDao.fetchOwnerById(ownerId));
		return new ResponseEntity<ResponseStructure<Owner>>(responseStructure,HttpStatus.FOUND)  ;	
		}
		else {
			throw new OwnerIdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructureList<Owner>> fetchAllOwner()
	{
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Successfully Owner fetched from the DB");
		responseStructureList.setData(ownerDao.fetchAllOwner());
		return new ResponseEntity<ResponseStructureList<Owner>>(responseStructureList,HttpStatus.FOUND)  ;
	}
	public ResponseEntity<ResponseStructure<Owner>> deleteOwnerById(int ownerId)
	{
		Owner owner=ownerDao.fetchOwnerById(ownerId);
		if(owner!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Owner deleted from the DB");
		responseStructure.setData(ownerDao.deleteOwnerById(ownerId));
		return new ResponseEntity<ResponseStructure<Owner>>(responseStructure,HttpStatus.OK)  ;
		}
		else
		{
			throw new OwnerIdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Owner>> updateOwnerById(int oldOwnerId,Owner newOwner)
	{
		Owner owner=ownerDao.fetchOwnerById(oldOwnerId);
		if(owner!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Owner updated in the DB");
		responseStructure.setData(ownerDao.updateOwnerById(oldOwnerId, newOwner));
		return new ResponseEntity<ResponseStructure<Owner>>(responseStructure,HttpStatus.OK)  ;
		}
		else
		{
			throw new OwnerIdNotFoundException();
		}
	}
	

}
