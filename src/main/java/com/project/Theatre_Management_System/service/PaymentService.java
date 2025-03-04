package com.project.Theatre_Management_System.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Theatre_Management_System.dao.PaymentDao;
import com.project.Theatre_Management_System.dto.Payment;
import com.project.Theatre_Management_System.exception.PaymentIdNotFoundException;
import com.project.Theatre_Management_System.util.ResponseStructure;
import com.project.Theatre_Management_System.util.ResponseStructureList;

@Service
public class PaymentService {

	@Autowired
	PaymentDao paymentDao;
	
	@Autowired
	ResponseStructure<Payment> responseStructure;
	
	@Autowired
	ResponseStructureList<Payment> responseStructureList;
	
	public ResponseEntity<ResponseStructure<Payment>>  savePayment(Payment payment)
	{
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Payment inserted into DB");
		responseStructure.setData(paymentDao.savePayment(payment));
		return new ResponseEntity<ResponseStructure<Payment>>(responseStructure,HttpStatus.CREATED) ;
	}
	public ResponseEntity<ResponseStructure<Payment>> fetchPaymentById(int paymentId)
	{
		Payment payment=paymentDao.fetchPaymentById(paymentId);
		if(payment!=null)
		{
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Payment fetched from the DB");
		responseStructure.setData(paymentDao.fetchPaymentById(paymentId));
		return new ResponseEntity<ResponseStructure<Payment>>(responseStructure,HttpStatus.FOUND) ;
		}
		else {
			throw new PaymentIdNotFoundException();
		}
		
	}
	public ResponseEntity<ResponseStructureList<Payment>>  fetchAllPayment()
	{
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Successfully All Payments fetched from the DB");
		responseStructureList.setData(paymentDao.fetchAllPayment());
		return new ResponseEntity<ResponseStructureList<Payment>>(responseStructureList,HttpStatus.FOUND) ;
		 
	}
	public ResponseEntity<ResponseStructure<Payment>> updatePaymentById(int oldPaymentId,Payment newPayment)
	{
		Payment payment=paymentDao.fetchPaymentById(oldPaymentId);
		if(payment!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Payment got updated in the DB");
		responseStructure.setData(paymentDao.updatePaymentById(oldPaymentId, newPayment));
		return new ResponseEntity<ResponseStructure<Payment>>(responseStructure,HttpStatus.OK) ;
		}
		else {
			throw new PaymentIdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Payment>> deletePaymentById(int paymentId)
	{
		Payment payment=paymentDao.fetchPaymentById(paymentId);
		if(payment!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Payment got deleted in the DB");
		responseStructure.setData(paymentDao.deletePaymentById(paymentId));
		return new ResponseEntity<ResponseStructure<Payment>>(responseStructure,HttpStatus.OK) ;
		}
		else {
			throw new PaymentIdNotFoundException();
		}
	}

}
