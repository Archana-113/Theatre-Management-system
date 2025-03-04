package com.project.Theatre_Management_System.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Theatre_Management_System.dao.PaymentDao;
import com.project.Theatre_Management_System.dao.TicketDao;
import com.project.Theatre_Management_System.dto.Payment;
import com.project.Theatre_Management_System.dto.Ticket;
import com.project.Theatre_Management_System.exception.PaymentIdNotFoundException;
import com.project.Theatre_Management_System.exception.TicketIdNotFoundException;
import com.project.Theatre_Management_System.util.ResponseStructure;
import com.project.Theatre_Management_System.util.ResponseStructureList;

@Service
public class TicketService {
	
	@Autowired
	TicketDao ticketDao;
	
	@Autowired
	PaymentDao paymentDao;
	
	@Autowired
	ResponseStructure<Ticket> responseStructure;
	
	@Autowired
	ResponseStructureList<Ticket> responseStructureList;
	
	public ResponseEntity<ResponseStructure<Ticket>>  saveTicket(Ticket ticket)
	{
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Ticket inserted into DB");
		responseStructure.setData(ticketDao.saveTicket(ticket));
		return new ResponseEntity<ResponseStructure<Ticket>>(responseStructure,HttpStatus.CREATED) ;
	}
	public ResponseEntity<ResponseStructure<Ticket>> addExistingPaymentToExistingTicket(int paymentId,int ticketId)
	{
		Ticket ticket=ticketDao.fetchTicketById(ticketId);
		Payment payment=paymentDao.fetchPaymentById(paymentId);
		if(ticket!=null&&payment!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Payment is added to the Ticket in the DB");
		responseStructure.setData(ticketDao.addExistingPaymentToExistingTicket(paymentId, ticketId));
		return new ResponseEntity<ResponseStructure<Ticket>>(responseStructure,HttpStatus.OK) ;
		}
		else if(payment==null)
		{
			throw new PaymentIdNotFoundException();
		}
		else {
			throw new TicketIdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Ticket>> fetchticketById(int ticketId)
	{
		Ticket ticket=ticketDao.fetchTicketById(ticketId);
		if(ticket!=null)
		{
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Ticket fetched from the DB");
		responseStructure.setData(ticketDao.fetchTicketById(ticketId));
		return new ResponseEntity<ResponseStructure<Ticket>>(responseStructure,HttpStatus.FOUND) ;
		}
		else {
			throw new TicketIdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructureList<Ticket>> fetchAllTicket()
	{
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Successfully all Tickets fetched from the DB");
		responseStructureList.setData(ticketDao.fetchAllTicket());
		return new ResponseEntity<ResponseStructureList<Ticket>>(responseStructureList,HttpStatus.FOUND) ;	
	}
	
	public ResponseEntity<ResponseStructure<Ticket>> updateTicketById(int oldTicketId,Ticket newTicket)
	{
		Ticket ticket=ticketDao.fetchTicketById(oldTicketId);
		if(ticket!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Ticket got updated in the DB");
		responseStructure.setData(ticketDao.updateTicketById(oldTicketId, newTicket));
		return new ResponseEntity<ResponseStructure<Ticket>>(responseStructure,HttpStatus.OK) ;
		}
		else {
			throw new TicketIdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructure<Ticket>> deleteTicketById(int ticketId)
	{
		Ticket ticket=ticketDao.fetchTicketById(ticketId);
		if(ticket!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Ticket got deleted from the DB");
		responseStructure.setData(ticketDao.deleteTicketById(ticketId));
		return new ResponseEntity<ResponseStructure<Ticket>>(responseStructure,HttpStatus.OK) ;
		}
		else {
			throw new TicketIdNotFoundException();
		}
	}

}
