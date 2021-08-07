<%@page import="com.rs.fer.service.impl.FERServiceImpl"%>
<%@page import="com.rs.fer.service1.FERService"%>
<%!FERService ferService = new FERServiceImpl();%>

<%
	String email = request.getParameter("email");
boolean isEmailAvailable = ferService.isEmailAvailable(email);
out.println(isEmailAvailable ? "Y" : "N");
%>