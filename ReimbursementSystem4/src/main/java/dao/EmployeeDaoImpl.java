package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import interfaces.PersonalTicketDaoInterface;
import models.Ticket;

/**
 * 
 * Employee ticket data access
 * @author Jonathan
 *
 */
public class EmployeeDaoImpl implements PersonalTicketDaoInterface{
	
	protected static String url = "jdbc:postgresql://"+System.getenv("DB_URL")+"/Employee&TicketDB";
	protected static String username = System.getenv("DB_USERNAME");
	protected static String password = System.getenv("DB_PASSWORD");
	//private int myEmployeeId = 0;//invalid id, should change to a valid one when logging in
	
	//IF YOU WANT TO USE JDBC WITH A WAR PROJECT YOU NEED TO DO THE FOLLOWING:
	static { //(this would normally go into your dao layer)
	      try {
	          Class.forName("org.postgresql.Driver");
	      }catch(ClassNotFoundException e) {
	          e.printStackTrace();
	          System.out.println("Static block has failed me");
	      }
	}
	
	/**
	 * Allows the employee to create a ticket
	 */
	@Override
	public void makeTicket(Ticket ticket) {
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			String statement = "INSERT INTO Tickets values(DEFAULT, ?, ?, ?, DEFAULT )";
			
			PreparedStatement ps = conn.prepareStatement(statement);
			ps.setInt(1, ticket.getEmployeeId());
			ps.setInt(2, ticket.getRequestAmount());
			ps.setString(3, ticket.getRequestDescription());
			ps.executeUpdate();
//			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Allows the employee to see a ticket by id
	 */
	@Override
	public Ticket getTicket(int ticketId, int employeeId) {

		try(Connection conn = DriverManager.getConnection(url, username, password)){

			Ticket newTicket = null;

			String statement = "SELECT * FROM employee_ticket_join WHERE ticket_id = ? AND employee_id = ?";

			PreparedStatement ps = conn.prepareStatement(statement);
			ps.setInt(1, ticketId);
			ps.setInt(2, employeeId);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				newTicket = new Ticket(rs.getInt(1), rs.getString(3), rs.getInt(5), rs.getString(6));
			}

			return newTicket;

		}catch(SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	/**
	 * Allows the employee to see all their tickets
	 */
	@Override
	public List<Ticket> getAllPersonalTickets(int employeeId) {
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			Ticket newTicket = null;
			List<Ticket> ticketList = new ArrayList<>();
		
			String statement = "SELECT * FROM make_inner_join WHERE employee_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(statement);
			ps.setInt(1, employeeId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				newTicket = new Ticket(rs.getInt(1), rs.getString(3), rs.getInt(5), rs.getString(6));
				ticketList.add(newTicket);
			}
			
			return ticketList;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
