package com.project.Theatre_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Theatre_Management_System.dto.Branch;
import com.project.Theatre_Management_System.dto.Theatre;
import com.project.Theatre_Management_System.repo.TheatreRepo;

@Repository
public class TheatreDao {
	
	@Autowired
	TheatreRepo theatreRepo;
	
	@Autowired
	BranchDao branchDao;
	
	public Theatre saveTheatre(Theatre theatre)
	{
		return theatreRepo.save(theatre);
	}
	
	public Theatre addExistingBranchToExistingTheatre(int branchId,int theatreId)
	{
		Branch branch= branchDao.fetchBranchById(branchId);
		Theatre theatre= fetchTheatreById(theatreId);
		List<Branch> list=theatre.getBranches();
		list.add(branch);
		theatre.setBranches(list);
		return saveTheatre(theatre);
	}
	
	public Theatre addNewBranchToExistingTheatre(int theatreId,Branch newBranch)
	{
		Theatre theatre=fetchTheatreById(theatreId);
		List<Branch> list=theatre.getBranches();
		list.add(newBranch);
		theatre.setBranches(list);
		return saveTheatre(theatre);
	}
	
	public Theatre fetchTheatreById(int theatreId)
	{
		Optional<Theatre> dbTheatre= theatreRepo.findById(theatreId);
		if(dbTheatre.isPresent())
		{
			return dbTheatre.get();
		}
		return null;
	}
	
	public List<Theatre> fetchAllTheatre()
	{
		return theatreRepo.findAll();		
	}
	
	public Theatre updateTheatreById(int oldTheatreId,Theatre newTheatre)
	{
		newTheatre.setTheatreId(oldTheatreId);
		return saveTheatre(newTheatre);
	}
	
	public Theatre deleteTheatreById(int theatreId)
	{
		Theatre theatre= fetchTheatreById(theatreId);
		theatreRepo.delete(theatre);
		return theatre;
	}
	

}
