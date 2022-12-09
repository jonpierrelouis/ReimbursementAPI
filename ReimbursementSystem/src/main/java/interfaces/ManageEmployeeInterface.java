package interfaces;

import java.util.List;

import models.Employee;
import models.Manager;

public interface ManageEmployeeInterface {

	public List<Employee> seeAllEmployees();
	
	public Employee seeEmployeeById(int employeeId);
	
	public void promoteEmployee(int employeeId);
	
	public void demoteManager(int employeeId);
	
}
