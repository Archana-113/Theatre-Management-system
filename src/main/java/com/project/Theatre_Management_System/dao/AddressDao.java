package com.project.Theatre_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Theatre_Management_System.dto.Address;
import com.project.Theatre_Management_System.repo.AddressRepo;

@Repository
public class AddressDao {
	
	@Autowired
	AddressRepo addressRepo;
	
	public Address saveAddress(Address address)
	{
		return addressRepo.save(address);
	}
	public Address fetchAddressById(int addressid)
	{
		Optional<Address> dbAddress= addressRepo.findById(addressid);
		if(dbAddress.isPresent())
		{
			return dbAddress.get();
		}
		else
		{
			return null;
		}	
	}
	public List<Address> fetchAllAddress()
	{
		return addressRepo.findAll();		
	}
	
	public Address updateAddressById(int oldAddressId,Address newAddress)
	{
		newAddress.setAddressId(oldAddressId);
		return saveAddress(newAddress);
	}
	public Address deleteAddressById(int addressId)
	{
		Address address=fetchAddressById(addressId);
		addressRepo.delete(address);
		return address;
	}

}
