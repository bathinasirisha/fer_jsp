
<%@page import="com.rs.fer.bean.Expense"%>
<%@page import="java.util.List"%>
<%@page import="com.rs.fer.service.impl.FERServiceImpl"%>
<%@page import="com.rs.fer.service1.FERService"%>
<%!FERService ferService = new FERServiceImpl(); %>
	<jsp:include page="Layout/HeaderAndLeftFrame.jsp"/>
<html>
<head>
<title>DeleteExpense</title>
<script>
	function validateForm(){
		var form=document.DashboardForm;
		var errorMessages='';
		
		
		if(form.expenseId.value.trim() == ''){
			errorMessages+='Please enter ExpenseId<BR>';
		}
		
		
		if(errorMessages !=''){
			//alert(errorMessages);
			var errorTrObj=document.getElementById('errorTrId');
			var errorTdObj=document.getElementById('errorTdId');
			
			errorTdObj.innerHTML=errorMessages;
			errorTrObj.style.display='';

		}else{
			submitForm('EditExpense.jsp');
		}
	}
</script>
</head>
<%

	Object username = session.getAttribute("username");

	int userId = Integer.parseInt(session.getAttribute("userId").toString());

	// 2.call the service
	
	List<Expense> expenses = ferService.getExpenses(userId);

	if (expenses == null || expenses.isEmpty()) {
		out.println("No Expense Found..");
	} else {

		out.println("ExpenseId <font color='red'>*</font>&nbsp");

		out.println("<select name='expenseId'>");
		out.println("<option value='' >Please select ExpenseId</option>");

		int value = 0;
		String description = null;
		for (Expense expense : expenses) {
			value = expense.getId(); 
			description = expense.getId() + "," + expense.getExpenseType() + "," + expense.getDate() + ","
					+ expense.getPrice() + "," + expense.getNumberOfItems() + "," + expense.getTotal() + " and "
					+ expense.getByWhom();
			out.println("<option value='" + value + "'>" + description + "</option>");
		}
		out.println("</select>");
		out.println(
				"<input type=\"button\"value=\"Next\"onclick=\"javascript: validateForm()\">");

	}
	%>
	<body>
<table>
		<tr style='display:none; color:red' id='errorTrId'>
		<td colspan='2' align='left' id='errorTdId'></td>
		</tr>
		</table>
</body>
</html>

	<jsp:include page="Layout/Footer.jsp"/>


