<%@page import="com.rs.fer.service.impl.FERServiceImpl"%>
<%@page import="com.rs.fer.service1.FERService"%>
<%!FERService ferService=new FERServiceImpl();
 %>
 	<jsp:include page="Layout/HeaderAndLeftFrame.jsp"/>
 
<% 
	

		String newPassword=request.getParameter("newPassword");
		int userId=Integer.parseInt(session.getAttribute("userId").toString());
		String currentPassword=request.getParameter("currentPassword");
						
		
		boolean isReset=ferService.resetPassword(newPassword,userId,currentPassword);
		
		if(isReset) {
			out.println("reset password successful.");
		}
		else {
			out.println("reset password not successful.");
		}
	
%>
				<jsp:include page="Layout/Footer.jsp"/>
