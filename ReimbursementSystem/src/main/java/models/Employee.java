package models;

/**
 * Model for Employee
 * @author Jonathan
 *
 */
public class Employee {
	
	private int employeeId;
	private String name;
	private String jobTitle;
	
	public Employee() {
	
	}

	/**
	 * @param employeeId
	 * @param name
	 * @param jobTitle
	 */
	public Employee(int employeeId, String name, String jobTitle) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.jobTitle = jobTitle;
	}

	/**
	 * @return the employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the jobTitle
	 */
	public String getJobTitle() {
		return jobTitle;
	}

	/**
	 * @param jobTitle the jobTitle to set
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	@Override
	public String toString() {
		return "\nEmployee [Employee Id: " + employeeId + "| Name: " + name + "| JobTitle: " + jobTitle + "]";
	}
	
	
	
	
	

}
