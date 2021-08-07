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
@WebServlet("/resetPassword")
public class ResetPasswordServlet extends HttpServlet{

	FERService ferService=null;
	@Override
	public void init() throws ServletException {
		ferService=new FERServiceImpl();
		
	}
		 
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String newPassword=request.getParameter("newPassword");
			HttpSession session=request.getSession();
			int userId=Integer.parseInt(session.getAttribute("userId").toString());
			String currentPassword=request.getParameter("currentPassword");
							
			
			boolean isReset=ferService.resetPassword(newPassword,userId,currentPassword);
			
			PrintWriter out=response.getWriter();
			//String nextPath=null;
			if(isReset) {
				out.println("reset password successful.");
				//nextPath="Dashboard.html";
			}
			else {
				out.println("reset password not successful.");
				//nextPath="Login.html";
			}
			//request.getRequestDispatcher(nextPath).include(request, response);
		}
		@Override
		public void destroy() {
			ferService=null;
		}

}
