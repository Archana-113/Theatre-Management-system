package com.project.Theatre_Management_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Theatre_Management_System.dao.AddressDao;
import com.project.Theatre_Management_System.dto.Address;
import com.project.Theatre_Management_System.exception.AddressIdNotFoundException;
import com.project.Theatre_Management_System.util.ResponseStructure;
import com.project.Theatre_Management_System.util.ResponseStructureList;

@Service
public class AddressService {
	
	@Autowired
	AddressDao addressDao;
	
	@Autowired
	ResponseStructure<Address> responseStructure;
	
	@Autowired
	ResponseStructureList<Address> responseStructureList;
	public ResponseEntity<ResponseStructure<Address>>  saveAddress(Address address)
	{
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Address is inserted into DB");
		responseStructure.setData(addressDao.saveAddress(address));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.CREATED) ;
	}
	public ResponseEntity<ResponseStructure<Address>>  fetchAddressById(int addressId)
	{
		Address address=addressDao.fetchAddressById(addressId);
		if(address!=null)
		{
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Address is fetched from DB");
		responseStructure.setData(addressDao.fetchAddressById(addressId));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.FOUND) ;
		}
		else {
			throw new AddressIdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructureList<Address>>  fetchAllAddress()
	{
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Successfully all Addresses are fetched from DB");
		responseStructureList.setData(addressDao.fetchAllAddress());
		return new ResponseEntity<ResponseStructureList<Address>>( responseStructureList,HttpStatus.FOUND);		
	}
	
	public ResponseEntity<ResponseStructure<Address>>  updateAddressById(int oldAddressId,Address newAddress)
	{
		Address address=addressDao.fetchAddressById(oldAddressId);
		if(address!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Address got updated in the DB");
		responseStructure.setData(addressDao.updateAddressById(oldAddressId, newAddress));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK) ;
		}
		else {
			throw new AddressIdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructure<Address>> deleteAddressById(int addressId)
	{
		Address address=addressDao.fetchAddressById(addressId);
		if(address!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Address got deleted from the DB");
		responseStructure.setData(addressDao.deleteAddressById(addressId));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK) ;
		}
		else {
			throw new AddressIdNotFoundException();
		}
	}

}
