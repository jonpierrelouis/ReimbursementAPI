package interfaces;

import java.util.List;

import models.Ticket;


/**
 * Interface to allow employees to make and see all
 * tickets that they themselves have created
 * @author Jonathan
 *
 */
public interface PersonalTicketDaoInterface {
	
	public void makeTicket(Ticket ticket);
	
	public Ticket getTicket(int ticketId, int employeeId);
	
	public List<Ticket> getAllPersonalTickets(int employeeId);

}
