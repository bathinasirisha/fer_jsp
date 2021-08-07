package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.bean.User;
import com.rs.fer.service.impl.FERServiceImpl;
import com.rs.fer.service1.FERService;
import com.rs.fer.util.LayoutUtil;

@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet{

	FERService ferService = null;
	@Override
	public void init() throws ServletException {
		ferService = new FERServiceImpl();

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		int userId = Integer.parseInt(session.getAttribute("userId").toString());

		User user=(User)session.getAttribute("user"); 
		
		
		//session.setAttribute("user", user);
		boolean isUserUpdate = ferService.updateUser(user);
		PrintWriter out = response.getWriter();
		LayoutUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("username"));



		if (isUserUpdate) {
			out.println("User profile updates successfully");
		} else {
			out.println("User Update is failed");
		}

		LayoutUtil.displayFooter(request, response);

	}

	@Override
	public void destroy() {
		ferService = null;
	}
}