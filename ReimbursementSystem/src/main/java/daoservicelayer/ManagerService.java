package daoservicelayer;

import java.util.List;

import dao.ManagerDaoImpl;
import models.Employee;
import models.Ticket;

public class ManagerService {
	
	/////Employee Management
	
	/**
	 * see all employees
	 * @return List of Employees
	 */
	public List<Employee> seeAllEmployeesService(){
		
		ManagerDaoImpl man = new ManagerDaoImpl();
		return man.seeAllEmployees();
	}
	
	/**
	 * See a single employee
	 * @param employeeId
	 * @return employee
	 */
	public Employee seeEmployeeByIdService(int employeeId) {
		
		ManagerDaoImpl man = new ManagerDaoImpl();
		return man.seeEmployeeById(employeeId);
	}
	
	/**
	 * Promote an employee to manager
	 * @param employeeId
	 */
	public void promoteEmployeeService(int employeeId) {
		
		ManagerDaoImpl man = new ManagerDaoImpl();
		man.promoteEmployee(employeeId);
	}
	
	/**
	 * Demote a manager to employee
	 * @param employeeId
	 */
	public void demoteManagerService(int employeeId) {
		
		ManagerDaoImpl man = new ManagerDaoImpl();
		man.demoteManager(employeeId);
	}
	
	///////Ticket Management
	
	/**
	 * See all tickets
	 * @return List of Tickets
	 */
	public List<Ticket> getAllTicketsService(){
		
		ManagerDaoImpl man = new ManagerDaoImpl();
		return man.getAllTickets();
	}
	
	/**
	 * see a list of tickets given an employeeId
	 * @param employeeId
	 * @return List of Tickets
	 */
	public List<Ticket> getAllTicketsOfEmployeeService(int employeeId){
		
		ManagerDaoImpl man = new ManagerDaoImpl();
		return man.getAllTicketsOfEmployee(employeeId);
	}
	
	/**
	 * See a single ticket
	 * @param ticketId
	 * @return Ticket
	 */
	public Ticket getOneTicketFromEmployeeService(int ticketId) {
		
		ManagerDaoImpl man = new ManagerDaoImpl();
		return man.getOneTicketFromEmployee(ticketId);
	}
	
	/**
	 * Approve or deny a given ticket
	 * decision = true to approve
	 * decision = false to deny
	 * @param ticketId
	 * @param decision
	 */
	public void approveTicket(int ticketId, boolean decision) {
		
		ManagerDaoImpl man = new ManagerDaoImpl();
		man.approveTicket(ticketId, decision);
	}

}
