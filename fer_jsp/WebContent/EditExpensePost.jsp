<%@page import="com.rs.fer.bean.Expense"%>
<%@page import="com.rs.fer.service.impl.FERServiceImpl"%>
<%@page import="com.rs.fer.service1.FERService"%>
<jsp:include page="Layout/HeaderAndLeftFrame.jsp"/>
<%!FERService ferService=new FERServiceImpl();
 %>
<% 
	
		int expenseId = Integer.parseInt(session.getAttribute("expenseId").toString());
		Expense expense = new Expense();

		expense.setExpenseType(request.getParameter("expenseType"));
		expense.setDate(request.getParameter("date"));
		expense.setPrice(Float.parseFloat(request.getParameter("price")));
		expense.setNumberOfItems(Integer.parseInt(request.getParameter("noOfItems")));
		expense.setTotal((Float.parseFloat(request.getParameter("total"))));
		expense.setByWhom(request.getParameter("byWhom"));
		expense.setId(expenseId);

		boolean isEditExpense = ferService.editExpense(expense);
		
		if(isEditExpense) {
			out.println("Expense edited successfully..");
		}
		else {
			out.println("Expense edit failed");
		}

	
%>
<jsp:include page="Layout/Footer.jsp"/>
