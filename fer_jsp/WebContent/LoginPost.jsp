<%@page import="com.rs.fer.service.impl.FERServiceImpl"%>
<%@page import="com.rs.fer.service1.FERService"%>
<%!FERService ferService=new FERServiceImpl(); %>
<% 
		
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			
			
			//Get the user id from freservice login method.
			int userId=ferService.login(username,password);
			
			String nextPath=null;
			if(userId>0) {

				//load the attribute into session
				session.setAttribute("userId", userId);
				session.setAttribute("username", username);
				session.setAttribute("status","Welcome to the user:" +username);
		%>
	
				<jsp:include page="Dashboard.jsp"/>
		<% 	}
			else {
				out.println("Incorrect usename/password. please try again later...");
						%>
				<jsp:include page="Login.jsp"/>
			<%}
		%>