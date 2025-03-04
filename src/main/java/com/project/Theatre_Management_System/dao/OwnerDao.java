package com.project.Theatre_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Theatre_Management_System.dto.Owner;
import com.project.Theatre_Management_System.dto.Theatre;
import com.project.Theatre_Management_System.repo.OwnerRepo;

@Repository
public class OwnerDao {
	
	@Autowired
	OwnerRepo ownerRepo;
	
	@Autowired
	TheatreDao theatreDao;
	
	public Owner saveOwner(Owner owner)
	{
		return ownerRepo.save(owner);
	}
	
	public Owner addExixtingTheatreToExistingOwner(int theatreId,int ownerId)
	{
		Theatre theatre=theatreDao.fetchTheatreById(theatreId);
		Owner owner= fetchOwnerById(ownerId);
		owner.setTheatre(theatre);
		return saveOwner(owner);	
	}
	public Owner fetchOwnerById(int ownerId)
	{
		Optional<Owner> dbOwner= ownerRepo.findById(ownerId);
		if(dbOwner.isPresent())
		{
			return dbOwner.get();
		}
		return null;	
	}
	
	public List<Owner> fetchAllOwner()
	{
		return ownerRepo.findAll();
	}
	public Owner deleteOwnerById(int ownerId)
	{
		Owner owner= fetchOwnerById(ownerId);
		ownerRepo.delete(owner);
		return owner;
	}
	
	public Owner updateOwnerById(int oldOwnerId,Owner newOwner)
	{
		newOwner.setOwnerId(oldOwnerId);
		return saveOwner(newOwner);
	}

}
