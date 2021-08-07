package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rs.fer.bean.User;
import com.rs.fer.service.impl.FERServiceImpl;
import com.rs.fer.service1.FERService;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

	FERService ferService = null;

	@Override
	public void init() throws ServletException {
		ferService = new FERServiceImpl();

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();

		user.setFirstName(request.getParameter("firstname"));
		user.setMiddleName(request.getParameter("middlename"));
		user.setLastName(request.getParameter("lastname"));
		user.setEmail(request.getParameter("email"));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setMobile(request.getParameter("mobile"));

		boolean isRegister = ferService.registration(user);

		PrintWriter out = response.getWriter();
		String nextPath = null;
		if (isRegister) {
			out.println("Registration successful.");
			nextPath = "Login.html";
		} else {
			out.println("Registration not successful.");
			nextPath = "Registration.html";
		}
		request.getRequestDispatcher(nextPath).include(request, response);
	}

	@Override
	public void destroy() {
		ferService = null;
	}
}
