	<%@page import="com.rs.fer.bean.Expense"%>
<%@page import="java.util.List"%>
<%@page import="com.rs.fer.service.impl.FERServiceImpl"%>
<%@page import="com.rs.fer.service1.FERService"%>
<jsp:include page="Layout/HeaderAndLeftFrame.jsp"/>
<%!	FERService ferService=new FERServiceImpl();
 %>
<% 

	int userId=Integer.parseInt(session.getAttribute("userId").toString());
	//int expenseId=Integer.parseInt(session.getAttribute("expenseId").toString());

	String expenseType=request.getParameter("expenseType");
	String fromDate=request.getParameter("fromDate");
	String toDate=request.getParameter("toDate");
	
	//2.call the service
	
	List<Expense> expenses=ferService.getExpenseReport(userId,expenseType,fromDate,toDate);
	
	//expense=ferService.getExpenseReport(userId,expenseType,fromDate,toDate);


	if (expenses==null || expenses.isEmpty()) {
		out.println("Expense not found");
	} else {
		
		out.println("<table border='1' align='center'>");
		out.println("	<tr>");

		out.println("		<td colspan='6' align='center'>Expense Report</td>");
		out.println("	</tr>");

		out.println("	<tr>");
		out.println("		<td>Expense Type</td>");
		out.println("		<td>Date</td>");
		out.println("		<td>Price</td>");
		out.println("		<td>No Of Items</td>");
		out.println("		<td>Total</td>");
		out.println("		<td>By Whom</td>");
		out.println("	</tr>");

		for(Expense expense : expenses) {
			out.println("	<tr>");
			out.println("		<td>"+expense.getExpenseType()+"</td>");
			out.println("		<td>"+expense.getDate()+"</td>");
			out.println("		<td>"+expense.getPrice()+"</td>");
			out.println("		<td>"+expense.getNumberOfItems()+"</td>");
			out.println("		<td>"+expense.getByWhom()+"</td>");
			out.println("		<td>"+expense.getUserId()+"</td>");
			out.println("	</tr>");

		}
		
		out.println("</table>");
	}
	

%>
				<jsp:include page="Layout/Footer.jsp"/>
