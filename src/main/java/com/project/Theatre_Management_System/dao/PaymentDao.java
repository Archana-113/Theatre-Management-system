package com.project.Theatre_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Theatre_Management_System.dto.Payment;
import com.project.Theatre_Management_System.repo.PaymentRepo;

@Repository
public class PaymentDao {
	@Autowired
	PaymentRepo paymentRepo;
	
	public Payment savePayment(Payment payment)
	{
		return paymentRepo.save(payment);
	}
	public Payment fetchPaymentById(int paymentId)
	{
	   Optional<Payment>	 dbPayment= paymentRepo.findById(paymentId);
	   if(dbPayment.isPresent() )
	   {
		   return dbPayment.get();
	   }
		return null;
		
	}
	public List<Payment> fetchAllPayment()
	{
		return paymentRepo.findAll();
		
	}
	public Payment updatePaymentById(int oldPaymentId,Payment newPayment)
	{
		newPayment.setPaymentId(oldPaymentId);
		return savePayment(newPayment);
	}
	
	public Payment deletePaymentById(int paymentId)
	{
		Payment payment=fetchPaymentById(paymentId);
		paymentRepo.delete(payment);
		return payment;
	}

}
