<%@page import="com.rs.fer.bean.Expense"%>
<%@page import="com.rs.fer.service.impl.FERServiceImpl"%>
<%@page import="com.rs.fer.service1.FERService"%>

<%!FERService ferService=new FERServiceImpl();
 %>

<jsp:include page="Layout/HeaderAndLeftFrame.jsp"/>

		<%
		int userId=Integer.parseInt(session.getAttribute("userId").toString());
		Expense expense = new Expense();

		expense.setExpenseType(request.getParameter("expenseType"));
		expense.setDate(request.getParameter("date"));
		expense.setPrice(Float.parseFloat(request.getParameter("price")));
		expense.setNumberOfItems(Integer.parseInt(request.getParameter("noOfItems")));
		expense.setTotal((Float.parseFloat(request.getParameter("total"))));
		expense.setByWhom(request.getParameter("byWhom"));
		expense.setUserId(userId);

		boolean isAddExpense = ferService.addExpense(expense);
		
		
		if(isAddExpense) {
			out.println("Expense added successfully..");
		}
		else {
			out.println("Expense add failed");
		}
		%>
		<jsp:include page="Layout/Footer.jsp"/>

