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

@WebServlet("/displayContactInfo")
public class DisplayContactInfoServlet extends HttpServlet{
	
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
		
		user.setFirstName(request.getParameter("firstName"));
		user.setMiddleName(request.getParameter("middleName"));
		user.setLastName(request.getParameter("lastName"));
		
		//session.setAttribute("user", user);


		PrintWriter out = response.getWriter();

		LayoutUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("username"));
		
		out.println("<table border='1' align='center' height='50px' width=60px>");
		out.println("<tr>");

		out.println("<td colspan='2' align='center'>Contact Info</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>email</td>");
		out.println("<td><input type='text' name='email' value='"+user.getEmail()+"'></td>");
		out.println("</tr>");


		out.println("<tr>");
		out.println("<td>Mobile</td>");
		out.println("<td><input type='text' name='mobile' value='"+user.getMobile()+"'></td>");
		out.println("</tr>");
		

		out.println("<tr>");
		out.println("<input type=\"submit\"value=\"Next\"onclick=\"javascript: submitForm('displayAddressInfo')\">");

			out.println("</td>");
			out.println("</tr>");
		out.println("</tr>");
		out.println("</table>");
		LayoutUtil.displayFooter(request, response);

	}

	@Override
	public void destroy() {
		ferService = null;
	}

}
