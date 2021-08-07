	<%@page import="com.rs.fer.service.impl.FERServiceImpl"%>
<%@page import="com.rs.fer.service1.FERService"%>
<jsp:include page="Layout/HeaderAndLeftFrame.jsp"/>
<%!FERService ferService =  new FERServiceImpl();
 %>
<% 


	int userId = Integer.parseInt(session.getAttribute("userId").toString());

	int expenseId = Integer.parseInt(request.getParameter("expenseId"));

	boolean isdeleteExpense = ferService.deleteExpense(expenseId);


	if (isdeleteExpense) {
		out.println("Expense deleteted successfully..");
	} else {
		out.println("Expense delete failed");
	}


%>
				<jsp:include page="Layout/Footer.jsp"/>
