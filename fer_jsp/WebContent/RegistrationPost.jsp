<%@page import="com.rs.fer.bean.User"%>
<%@page import="com.rs.fer.service.impl.FERServiceImpl"%>
<%@page import="com.rs.fer.service1.FERService"%>
<% 
	
FERService ferService =  new FERServiceImpl();

		User user = new User();

		user.setFirstName(request.getParameter("firstname"));
		user.setMiddleName(request.getParameter("middlename"));
		user.setLastName(request.getParameter("lastname"));
		user.setEmail(request.getParameter("email"));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setMobile(request.getParameter("mobile"));
		
		String nextPath = null;

		if(!ferService.isEmailAvailable(user.getEmail())){
			out.println("Email is not available.Please try again...");
			nextPath = "Registration.jsp";
		}else{
		boolean isRegister = ferService.registration(user);
 

		if (isRegister) {
			out.println("Registration successful.");
			nextPath = "Login.jsp";
		} else {
			out.println("Registration not successful.");
			nextPath = "Registration.jsp";
		}
		}
	%>
	<jsp:include page="<%=nextPath %>"/>