package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.service.impl.FERServiceImpl;
import com.rs.fer.service1.FERService;
import com.rs.fer.util.LayoutUtil;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	FERService ferService=null;
	@Override
	public void init() throws ServletException {
		ferService=new FERServiceImpl();
		
	}
		 
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			
			FERService ferService=new FERServiceImpl();
			
			//Get the user id from freservice login method.
			int userId=ferService.login(username,password);
			
			
			//Creating printEriter object to display data dynamicaaly.
			PrintWriter out=response.getWriter();
			String nextPath=null;
			if(userId>0) {

				//get the session object
				HttpSession session=request.getSession();
				
				//load the attribute into session
				session.setAttribute("userId", userId);
				session.setAttribute("username", username);
				
				
				LayoutUtil.displayHeaderAndLeftFrame(request, response, out, username);
				
				out.println("Welcome to the User:"+username);
				
				LayoutUtil.displayFooter(request, response);
			}
			else {
				out.println("Login not successful.");
				nextPath="Login.html";
			}
			request.getRequestDispatcher(nextPath).include(request, response);
		}
		@Override
		public void destroy() {
			ferService=null;
		}

}
