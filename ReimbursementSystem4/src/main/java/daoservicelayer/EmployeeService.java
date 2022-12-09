package daoservicelayer;

import java.util.List;

import dao.EmployeeDaoImpl;
import models.Ticket;

public class EmployeeService {
	
	/**
	 * make ticket service
	 * @param ticket
	 */
	public void makeTicketService(Ticket ticket) {
		
		EmployeeDaoImpl e = new EmployeeDaoImpl();
		e.makeTicket(ticket);	
	}
	
	/**
	 * get a ticket by id
	 * @param ticketId
	 * @return ticket
	 */
	public Ticket getTicketService(int ticketId, int employeeId) {
		
		EmployeeDaoImpl e = new EmployeeDaoImpl();
		return e.getTicket(ticketId, employeeId);
	}
	
	/**
	 * get all tickets of the employee
	 * @param employeeId
	 * @return
	 */
	public List<Ticket> getAllPersonalTicketsService(int employeeId){
	
		EmployeeDaoImpl e = new EmployeeDaoImpl();
		return e.getAllPersonalTickets(employeeId);
	}

}
