package com.project.Theatre_Management_System.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Theatre_Management_System.dao.TheatreDao;
import com.project.Theatre_Management_System.dto.Branch;
import com.project.Theatre_Management_System.dto.Theatre;
import com.project.Theatre_Management_System.exception.TheatreIdNotFoundException;
import com.project.Theatre_Management_System.util.ResponseStructure;
import com.project.Theatre_Management_System.util.ResponseStructureList;

@Service
public class TheatreService {
	
	@Autowired
	TheatreDao theatreDao;
	
	@Autowired
	ResponseStructure<Theatre> responseStructure;
	
	@Autowired
	ResponseStructureList<Theatre> responseStructureList;
	
	public ResponseEntity<ResponseStructure<Theatre>>  saveTheatre(Theatre theatre)
	{
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Theatre inserted into DB");
		responseStructure.setData(theatreDao.saveTheatre(theatre));
		return new ResponseEntity<ResponseStructure<Theatre>>(responseStructure,HttpStatus.CREATED) ;
	}
	
	public ResponseEntity<ResponseStructure<Theatre>> addExistingBranchToExistingTheatre(int branchId,int theatreId)
	{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Branch added to the Theatre into DB");
		responseStructure.setData(theatreDao.addExistingBranchToExistingTheatre(branchId, theatreId));
		return new ResponseEntity<ResponseStructure<Theatre>>(responseStructure,HttpStatus.OK) ;
	}
	public ResponseEntity<ResponseStructure<Theatre>> addNewBranchToExistingTheatre(int theatreId,Branch newBranch)
	{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully newBranch added to the Theatre into DB");
		responseStructure.setData(theatreDao.addNewBranchToExistingTheatre(theatreId, newBranch));
		return new ResponseEntity<ResponseStructure<Theatre>>(responseStructure,HttpStatus.OK) ;
	}

	public ResponseEntity<ResponseStructure<Theatre>> fetchTheatreById(int theatreId)
	{
		Theatre theatre=theatreDao.fetchTheatreById(theatreId);
		if(theatre!=null)
		{
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Theatre fetched from the DB");
		responseStructure.setData(theatreDao.fetchTheatreById(theatreId));
		return new ResponseEntity<ResponseStructure<Theatre>>(responseStructure,HttpStatus.FOUND) ;
		}
		else {
			throw new TheatreIdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructureList<Theatre>> fetchAllTheatre()
	{
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Successfully Theatre fetched from the DB");
		responseStructureList.setData(theatreDao.fetchAllTheatre());
		return new ResponseEntity<ResponseStructureList<Theatre>>(responseStructureList,HttpStatus.FOUND) ;		
	}
	
	public ResponseEntity<ResponseStructure<Theatre>> updateTheatreById(int oldTheatreId,Theatre newTheatre)
	{
		Theatre theatre=theatreDao.fetchTheatreById(oldTheatreId);
		if(theatre!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Theatre got updated in the DB");
		responseStructure.setData(theatreDao.updateTheatreById(oldTheatreId, newTheatre));
		return new ResponseEntity<ResponseStructure<Theatre>>(responseStructure,HttpStatus.OK) ;
		}
		else {
			throw new TheatreIdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Theatre>> deleteTheatreById(int theatreId)
	{
		Theatre theatre=theatreDao.fetchTheatreById(theatreId);
		if(theatre!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Theatre got deleted from the DB");
		responseStructure.setData(theatreDao.deleteTheatreById(theatreId));
		return new ResponseEntity<ResponseStructure<Theatre>>(responseStructure,HttpStatus.OK) ;
		}
		else {
			throw new TheatreIdNotFoundException();
		}
	}

}
