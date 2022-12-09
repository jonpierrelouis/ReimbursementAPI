package daoservicelayer;

import dao.LoginDao;
import models.Account;
import models.Employee;

public class LoginService {
	
	/**
	 * check to see if spaces are within inputted string
	 * @param String
	 * @return boolean
	 */
	private static boolean haveNoSpaces(String str) {
		
		char[] c = str.toCharArray();
		
		for(int i = 0; i < c.length; i++) {
			if(c[i] == ' ') {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * service the username and password of LoginDao.login 
	 * @param username
	 * @param password
	 * @return Employee
	 */
	public Employee loginService(Account account) {
		
		LoginDao d = new LoginDao();
		
		return d.login(account);
	}
	
	
	/**
	 * service the username and password of LoginDao.makeNewAccount and 
	 * checks if it is valid. Usually usernames and passwords
	 * do not have a space so it calls the haveSpaces() method 
	 * to check that condition.
	 * @param name
	 * @param username
	 * @param password
	 */
	public void makeNewAccountService(String name, String username, String password) {
		
		LoginDao d = new LoginDao();
		
		if(haveNoSpaces(username) && haveNoSpaces(password) ) {
			d.makeNewAccount(name, new Account(username, password));
		}else {
		
			System.out.println("Account creation failed");
			System.out.println("Please do not use spaces in username and password");
		}
	}

}
