package servlets.dispatches;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class home {
	
	public static void welcomeUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		PrintWriter printer = resp.getWriter();
		printer.println("Welcome!!");
		
	}

}
