package interfaces;

import models.Account;
import models.Employee;

public interface LoginInterface {
	
	public Employee login(Account account);
	
	public void makeNewAccount(String name, Account account);
	

}

