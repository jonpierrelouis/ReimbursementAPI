package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import interfaces.ManageEmployeeInterface;
import interfaces.ManageTicketDaoInterface;
import models.Employee;
import models.Manager;
import models.Ticket;

public class ManagerDaoImpl extends EmployeeDaoImpl implements ManageTicketDaoInterface, ManageEmployeeInterface {
	
	//IF YOU WANT TO USE JDBC WITH A WAR PROJECT YOU NEED TO DO THE FOLLOWING:
	static { //(this would normally go into your dao layer)
	      try {
	          Class.forName("org.postgresql.Driver");
	      }catch(ClassNotFoundException e) {
	          e.printStackTrace();
	          System.out.println("Static block has failed me");
	      }
	}
	//////////Employee Management
	
	/**
	 * See all current employees and managers
	 */
	@Override
	public List<Employee> seeAllEmployees() {

		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			Employee employee = null;
			List<Employee> employeeList = new ArrayList<>();
		
			String statement = "SELECT * FROM Employees;";
			
			PreparedStatement ps = conn.prepareStatement(statement);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				//int employeeId, String name, String jobTitle
				employee = new Employee(rs.getInt(1), rs.getString(4), rs.getString(5));
				employeeList.add(employee);
			}
			
			return employeeList;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	
		return null;
	}
	
	/**
	 * See an employee by referencing an id
	 */
	@Override
	public Employee seeEmployeeById(int employeeId) {
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			Employee employee = null;
		
			String statement = "SELECT * FROM Employees WHERE employee_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(statement);
			ps.setInt(1, employeeId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				//int employeeId, String name, String jobTitle
				employee = new Employee(rs.getInt(1), rs.getString(4), rs.getString(5));
			}
			
			return employee;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Promote an employee to manager
	 */
	@Override
	public void promoteEmployee(int employeeId) {

		try(Connection conn = DriverManager.getConnection(url, username, password)){
		
			String statement = "UPDATE Employees SET title = 'Manager' WHERE employee_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(statement);
			ps.setInt(1, employeeId);
			
			ps.executeUpdate();
	
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Demote a manager to employee
	 */
	@Override
	public void demoteManager(int managerId) {

		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			String statement = "UPDATE Employees SET title = 'Employee' WHERE employee_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(statement);
			ps.setInt(1, managerId);
			
			ps.executeUpdate();		
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	///////////Ticket Management

	/**
	 * Lists all tickets in the database
	 */
	@Override
	public List<Ticket> getAllTickets() {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			Ticket newTicket = null;
			List<Ticket> ticketList = new ArrayList<>();
		
			String statement = "SELECT * FROM employee_ticket_join;";
			
			PreparedStatement ps = conn.prepareStatement(statement);
			//ps.setInt(1, employeeID);
			
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

	@Override
	/**
	 * get all tickets of a choosen employee
	 */
	public List<Ticket> getAllTicketsOfEmployee(int employeeId) {
		
		return getAllPersonalTickets(employeeId);
	}
	
	/**
	 * get one ticket of an employee
	 */
	@Override
	public Ticket getOneTicketFromEmployee(int ticketId) {
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){

			Ticket newTicket = null;

			String statement = "SELECT * FROM employee_ticket_join WHERE ticket_id = ?;";

			PreparedStatement ps = conn.prepareStatement(statement);
			ps.setInt(1, ticketId);

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
	 * Approve a ticket given a ticketId, and the decision represented 
	 * as a boolean. True = approve, False = deny
	 */
	@Override
	public void approveTicket(int ticketId, boolean decision) {
		//get information
		//check status of ticket id
		//if pending continue
		//send exception if not
		try(Connection conn = DriverManager.getConnection(url, username, password)){

			String statement = "SELECT * FROM employee_ticket_join WHERE ticket_id = ?;";

			PreparedStatement ps = conn.prepareStatement(statement);
			ps.setInt(1, ticketId);
			
			//get status of ticket
			ResultSet rs = ps.executeQuery();

			String currentStatus = "";
			
			while(rs.next()) {
				currentStatus = rs.getString(7);
			}
			
			if (currentStatus.equals("PENDING")) {
				
				//set information
				//if decision(boolean) is true, change to approved
				//if decison is false, change to denied
				if(decision == true) {
					String updateStatement = "UPDATE Tickets SET status = 'APPROVED' WHERE ticket_id = ?";
					
					PreparedStatement ups = conn.prepareStatement(updateStatement);
					ups.setInt(1, ticketId);
					
					ups.executeUpdate();
				}else {
					
					String updateStatement = "UPDATE Tickets SET status = 'DENIED' WHERE ticket_id = ?";
					
					PreparedStatement ups = conn.prepareStatement(updateStatement);
					ups.setInt(1, ticketId);
					
					ups.executeUpdate();
				
				}
				
				System.out.println("Executed");
				
			}else {
				System.out.println("This ticket has already been approved or denied.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
