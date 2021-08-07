package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.User;
import com.rs.fer.service.impl.FERServiceImpl;
import com.rs.fer.service1.FERService;
import com.rs.fer.util.LayoutUtil;

@WebServlet("/displayReviewInfo")
public class DisplayReviewInfoServlet extends HttpServlet{

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
		Address address=user.getAddress();
		
		address.setLine1(request.getParameter("line1"));
		address.setLine2(request.getParameter("line2"));
		address.setCity(request.getParameter("city"));
		address.setState(request.getParameter("state"));
		address.setPincode(request.getParameter("pincode"));
		address.setCountry(request.getParameter("country"));

		PrintWriter out = response.getWriter();

		LayoutUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("username"));
		
		out.println("<table border='1' align='center' height='50px' width=60px>");
		out.println("<tr>");

		out.println("<td colspan='11' align='center'>Review Info</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("			<td>FirstName</td>");
		out.println("<td>");
		out.println(user.getFirstName());
		out.println("			</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>MiddleName</td>");
		out.println("			<td>");
		out.println(user.getMiddleName());
		out.println("			</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>LastName</td>");
		out.println("			<td>");
		out.println(user.getLastName());
		out.println("			</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Email</td>");
		out.println("			<td>");
		out.println(user.getEmail());
		out.println("			</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Mobile</td>");
		out.println("			<td>");
		out.println(user.getMobile());
		out.println("			</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Line1</td>");
		out.println("			<td>");
		out.println(address.getLine1());
		out.println("			</td>");
		out.println("</tr>");


		out.println("<tr>");
		out.println("<td>Line2</td>");
		out.println("			<td>");
		out.println(address.getLine2());
		out.println("			</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>City</td>");
		out.println("			<td>");
		out.println(address.getCity());
		out.println("</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>State</td>");
		out.println("			<td>");
		out.println(address.getState());
		out.println("			</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Pincode</td>");
		out.println("			<td>");
		out.println(address.getPincode());
		out.println("</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Country</td>");
		out.println("			<td>");
		out.println(address.getCountry());
		out.println("			</td>");
		out.println("</tr>");
		
		
		

		out.println("<tr>");
		out.println("<input type=\"submit\"value=\"Update Profile\"onclick=\"javascript: submitForm('updateUser')\">");

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
