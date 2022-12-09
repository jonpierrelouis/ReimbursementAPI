package models;

/**
 * Model for Ticket Reimbursement
 * @author Jonathan
 *
 */
public class Ticket {

	private int employeeId;
	private int requestAmount;
	private String requestDescription;
	private String employeeName;

	/**
	 * @param employeeId(int)
	 * @param requestAmount(int)
	 * @param requestDescription(String)
	 */
	
	public Ticket() {

	}
	
	public Ticket(int employeeId, String employeeName, int requestAmount, String requestDescription) {
		super();
		this.employeeId = employeeId;
		this.requestAmount = requestAmount;
		this.requestDescription = requestDescription;
		this.employeeName = employeeName;

	}
	
	//GETTERS AND SETTERS
	/**
	 * @return the requestFromEmployeeName
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param set requestFromEmployeeName
	 */
	public void getEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the requestAmount
	 */
	public int getRequestAmount() {
		return requestAmount;
	}

	/**
	 * @param set requestAmount
	 */
	public void setRequestAmount(int requestAmount) {
		this.requestAmount = requestAmount;
	}

	/**
	 * @return the requestDescription
	 */
	public String getRequestDescription() {
		return requestDescription;
	}

	/**
	 * @param set requestDescription 
	 */
	public void setRequestDescription(String requestDescription) {
		this.requestDescription = requestDescription;
	}

	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	//ToString
	@Override
	public String toString() {
		return "\nTickets [Employee ID: " + employeeId  +"| Employee Name: " +employeeName + "| Request Amount: " + requestAmount
				+ "| Request Description: " + requestDescription + "]";
	}
	
	
	
	
	
	
	
}
