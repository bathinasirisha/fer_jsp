<%@page import="com.rs.fer.bean.Address"%>
<%@page import="com.rs.fer.bean.User"%>
<%@page import="com.rs.fer.service.impl.FERServiceImpl"%>
<%@page import="com.rs.fer.service1.FERService"%>
<%!FERService ferService = new FERServiceImpl();
 %>
	<jsp:include page="Layout/HeaderAndLeftFrame.jsp"/>

<% 

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
out.println("<input type=\"submit\"value=\"Update Profile\"onclick=\"javascript: submitForm('UpdateUserPost.jsp')\">");

	out.println("</td>");
	out.println("</tr>");
out.println("</tr>");
out.println("</table>");

%>
				<jsp:include page="Layout/Footer.jsp"/>
