package gr.hua.dit.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gr.hua.dit.dao.adminDAO;
import gr.hua.dit.entities.User;

@Controller
@RequestMapping(value = "/Signin")
public class SigninController extends HttpServlet{

	private adminDAO admin;
	
	
	@RequestMapping(method = RequestMethod.POST)
    public String viewAttempt(HttpServletRequest request, Model model ) throws ServletException, IOException {

		
		
		String email = request.getParameter("email");
    	String password = request.getParameter("password");
    	
    	
    	
    	
    	List<User> users = admin.printUser();
    	
    	
    	
    	for(User u : users) {
     	   if(u.getEmail().equals(email) && u.getPassword().equals(password) && u.getRole().equals("admin")){
					return "Admin";
     	   }
     	   else if(u.getEmail().equals(email) && u.getPassword().equals(password) && u.getRole().equals("user")){
					return "homeScreen";
     	   }
				
         }
		return "homeScreen";
	
	}
}
	
	
	
	
	
	
	

