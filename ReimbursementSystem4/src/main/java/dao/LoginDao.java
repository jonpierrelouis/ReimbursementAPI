package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import interfaces.LoginInterface;
import models.Account;
import models.Employee;

public class LoginDao implements LoginInterface {

	private static String DB_url = "jdbc:postgresql://"+System.getenv("DB_URL")+"/Employee&TicketDB";
	private static String DB_username = System.getenv("DB_USERNAME");
	private static String DB_password = System.getenv("DB_PASSWORD");

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
	 * Allows for the login of a current employee
	 */
	@Override
	public Employee login(Account account) {
		int employeeId = 0;
		String name = "";
		String jobTitle = "";
		
		try(Connection conn = DriverManager.getConnection(DB_url, DB_username, DB_password)){
		
			String statement = "SELECT * FROM Employees WHERE username = ? AND user_password = ?;";
			
			PreparedStatement ps = conn.prepareStatement(statement);
			ps.setString(1, account.getUsername());
			ps.setString(2, account.getPassword());
			
			try {
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					employeeId = rs.getInt(1);
					name = rs.getString(4);
					jobTitle = rs.getString(5);
				}
				
				if(employeeId == 0) {
					return null;
				}
				
				return new Employee(employeeId, name, jobTitle);
				
			}catch(SQLException e) {
				System.out.println("Incorrect username and/or password");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * makes a new account for an employee
	 */
	@Override
	public void makeNewAccount(String name, Account account) {
		
		try(Connection conn = DriverManager.getConnection(DB_url, DB_username, DB_password)){
			
			String statement = "INSERT INTO Employees values(DEFAULT, ?, ?, ?, DEFAULT );";
			
			PreparedStatement ps = conn.prepareStatement(statement);
			ps.setString(1, account.getUsername());
			ps.setString(2, account.getPassword());
			ps.setString(3, name);
			
			try {
				ps.executeQuery();
								
			}catch(SQLException e) {
				System.out.println("This username and/or password already exists");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
