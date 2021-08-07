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

@WebServlet("/displayNameInfo")
public class DisplayNameInfoServlet extends HttpServlet{
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

		User user=ferService.getUser(userId);
		
		session.setAttribute("user", user);


		PrintWriter out = response.getWriter();

		LayoutUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("username"));
		
		if (user==null) {
			out.println("User not found");
		} else {
			
			out.println("<table border='1' align='center' height='50px' width=60px>");
			out.println("<tr>");

			out.println("<td colspan='3' align='center'>Name Info</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>FirstName</td>");
			out.println("<td><input type='text' name='firstName' value='"+user.getFirstName()+"'></td>");
			out.println("</tr>");


			out.println("<tr>");
			out.println("<td>MiddleName</td>");
			out.println("<td><input type='text' name='middleName' value='"+user.getMiddleName()+"'></td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>LastName</td>");
			out.println("<td><input type='text' name='lastName' value='"+user.getLastName()+"'></td>");
			out.println("</tr>");
		
			out.println("<tr>");
			out.println("<input type=\"submit\"value=\"Next\"onclick=\"javascript: submitForm('displayContactInfo')\">");

				out.println("</td>");
				out.println("</tr>");
			out.println("</tr>");
			out.println("</table>");
		}
		LayoutUtil.displayFooter(request, response);

	}

	@Override
	public void destroy() {
		ferService = null;
	}
}
