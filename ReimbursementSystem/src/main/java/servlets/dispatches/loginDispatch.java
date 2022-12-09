package servlets.dispatches;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daoservicelayer.LoginService;
import models.Account;
import models.Employee;

public class loginDispatch {
	
	public static void loginUser(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		
		//if not in the post, we will not continue b/c of security
		if(!req.getMethod().equals("POST")) {
			resp.getWriter().println("Use a 'POST' block");
			return;
		}
		
		//recovering the inputted username and password
		String inputUsername = req.getParameter("input_username");
		String inputPassword = req.getParameter("input_password");
		
		System.out.println(inputUsername);
		System.out.println(inputPassword);
		
		Employee signedInEmployee = new LoginService().loginService(new Account(inputUsername, inputPassword));
		System.out.println(signedInEmployee);
		
		//if credentials are correct, make new session
		if(signedInEmployee == null) {
			resp.getWriter().println("Incorrect Credentials");
			return;
		}else {
			HttpSession session = req.getSession();
			session.setAttribute(signedInEmployee.getName(), signedInEmployee);
			resp.getWriter().println("Welcome back, " +signedInEmployee.getName());
		}
		
	}
	
	
	public static void checkCurrentUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		Account sessionUser = (Account)session.getAttribute("currentUser");
		System.out.println(sessionUser);
		
		resp.setContentType("application/json");
		PrintWriter printer = resp.getWriter();
		
		
		printer.write(new ObjectMapper().writeValueAsString(sessionUser));
	}
	
	public static void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		session.invalidate();
		
		resp.setContentType("text/html");
		PrintWriter printer = resp.getWriter();
		printer.println("You've successfully logged out");
	}

}
