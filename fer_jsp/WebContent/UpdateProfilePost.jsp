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
boolean isUserUpdate = ferService.updateUser(user);

if (isUserUpdate) {
	out.println("User profile updates successfully");
} else {
	out.println("User Update is failed");
}

%>
				<jsp:include page="Layout/Footer.jsp"/>
