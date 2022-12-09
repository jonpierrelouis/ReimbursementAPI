package servlets.frontcontroller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlets.dispatches.home;
import servlets.dispatches.loginDispatch;

public class Dispatcher {

	public static void sendUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//System.out.println("put into the dispatcher");
		System.out.println(req.getRequestURI());
		switch(req.getRequestURI()) {
		
			case "/ReimbursementSystem3/home":
				home.welcomeUser(req, resp);
				break;
			
			case "/ReimbursementSystem3/login":
				loginDispatch.loginUser(req, resp);
				break;
				
			case "/ReimbursementSystem3/signup":
				//logic here...
				break;
			
	//		case "/ReimbursementSystem3/employeePortal":
	//			//logic here...
	//			break;
	//			
	//		case "/ReimbursementSystem3/managerPortal":
	//			//logic here...
	//			break;
			
			default:
				resp.getWriter().println("Invalid URL");
				resp.setStatus(404);
		}
			
		
	}
	
}
