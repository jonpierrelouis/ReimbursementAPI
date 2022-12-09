package interfaces;

import java.util.List;

import models.Ticket;

/**
 * Interface for managing all tickets 
 * @author Jonathan
 *
 */
public interface ManageTicketDaoInterface {

	public List<Ticket> getAllTickets();
	
	public List<Ticket> getAllTicketsOfEmployee(int employeeId);
	
	public Ticket getOneTicketFromEmployee(int ticketId);
	
	public void approveTicket(int ticketId, boolean decision);
	
	
}
